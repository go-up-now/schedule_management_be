package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.StudyInRequest;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;
import com.poly.schedule_manager_be.dto.response.StudyInResponse;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.StudyIn;
import com.poly.schedule_manager_be.entity.User;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.StudyInMapper;
import com.poly.schedule_manager_be.repository.ClazzRepository;
import com.poly.schedule_manager_be.repository.StudentRepository;
import com.poly.schedule_manager_be.repository.StudyInRepository;
import com.poly.schedule_manager_be.service.AuthenticationService;
import com.poly.schedule_manager_be.service.ClazzService;
import com.poly.schedule_manager_be.service.SemesterProgressService;
import com.poly.schedule_manager_be.service.StudyInService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class StudyInServiceImpl implements StudyInService {

    StudyInMapper studyInMapper;
    StudyInRepository studyInRepository;
    ClazzRepository clazzRepository;
    StudentRepository studentRepository;
    AuthenticationService authenticationService;
    SemesterProgressService semesterProgressService;

    @Override
    public StudyInResponse registrationClazz(StudyInRequest request) {
        StudyIn studyIn = studyInMapper.toStudyIn(request);

        Clazz clazz = clazzRepository.findById(request.getClazzId()).orElseThrow(()->
                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        if(this.countByStudentsInClazz(clazz) >= 40)
            throw new AppException(ErrorCode.FULL_CLAZZ);

        studyIn.setClazz(clazz);
        studyIn.setStudent(student);
        return studyInMapper.toStudyInResponse(studyInRepository.save(studyIn));
    }

    @Override
    public void delete(Integer subjectId) {
        for (StudyInResponse studyInResponse : this.getAllBySemetserAndYear()) {
            if(studyInResponse.getSubjectId() == subjectId)
                studyInRepository.deleteById(studyInResponse.getId());
            break;
        }
    }

    @Override
    public StudyInResponse getOne(Integer id) {
        return null;
    }

    @Override
    public List<StudyInResponse> getAllBySemetserAndYear() {
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        SemesterProgressResponse semesterProgress = semesterProgressService.getOneByStatusTrue();

        return studyInRepository.findAllByClazzSemesterAndClazzYearAndStudent(
                semesterProgress.getSubjectSemesterOpen(), semesterProgress.getSubjectYearOpen(), student
        ).stream().map(studyInMapper::toStudyInResponse).toList();
    }

//    @Override
//    public StudyInResponse getOneByClazzSemesterAndClazzYearAndClazzSubjectIdAndStudent(int subjectId) {
//        User user = authenticationService.getInforAuthenticated();
//        Student student = studentRepository.findByUser(user).orElseThrow(()->
//                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
//
//        SemesterProgressResponse semesterProgress = semesterProgressService.getOneByStatusTrue();
//
//        StudyIn studyIn =  studyInRepository.findByClazzSemesterAndClazzYearAndClazzSubjectIdAndStudent(
//                semesterProgress.getSubjectSemesterOpen(), semesterProgress.getSubjectYearOpen(),
//                subjectId, student
//        ).orElseThrow(()-> new AppException(ErrorCode.STUDYIN_NOT_EXISTED));
//        return studyInMapper.toStudyInResponse(studyIn);
//    }

    @Override
    public long countByStudentsInClazz(Clazz clazz) {
        return clazz.getStudyIns().size();
    }
}
