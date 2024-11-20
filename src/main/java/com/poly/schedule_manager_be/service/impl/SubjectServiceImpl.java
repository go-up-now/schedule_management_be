package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.SubjectRequest;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;
import com.poly.schedule_manager_be.dto.response.StudyHistoryResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.entity.PrivateMajor;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.Subject;
import com.poly.schedule_manager_be.entity.User;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.SubjectMapper;
import com.poly.schedule_manager_be.repository.ClazzRepository;
import com.poly.schedule_manager_be.repository.PrivateMajorRepository;
import com.poly.schedule_manager_be.repository.StudentRepository;
import com.poly.schedule_manager_be.repository.SubjectRepository;
import com.poly.schedule_manager_be.service.AuthenticationService;
import com.poly.schedule_manager_be.service.SemesterProgressService;
import com.poly.schedule_manager_be.service.StudyHistoryService;
import com.poly.schedule_manager_be.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;
    SubjectMapper subjectMapper;
    StudentRepository studentRepository;
    AuthenticationService authenticationService;
    SemesterProgressService semesterProgressService;
    StudyHistoryService studyHistoryService;
    PrivateMajorRepository privateMajorRepository;

    @Override
    public SubjectResponse create(SubjectRequest request) {
        return null;
    }

    @Override
    public SubjectResponse update(SubjectRequest request, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public SubjectResponse getOne(Integer id) {
        return null;
    }

    @Override
    public List<SubjectResponse> getAll() {
        return subjectRepository.findAll().stream().map(subjectMapper::toSubjectResponse).toList();
    }

    @Override
    public List<SubjectResponse> findSubjectBySemesterAndYear() {
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        SemesterProgressResponse semesterProgressResponse = semesterProgressService.getOneByStatusTrue();

        Set<Subject> listSubject = new HashSet<>();

        subjectRepository.findSubjectBySemesterAndYear(
            semesterProgressResponse.getSubjectSemesterOpen(),
            semesterProgressResponse.getSubjectYearOpen())
                .forEach(subject -> {
                    // Kiểm tra sv đã đăng ký môn học này chưa
                    if(!checkSubjectAndStudentExisted(subject, student)){
                        List<StudyHistoryResponse> studyHistories = studyHistoryService.getAllByStudent();

                        // Kiểm tra môn học đang mở có trong môn học cơ bản của chuyên ngành ko
                        student.getEducation_program().getSubjects().forEach(subject1 -> {
                            if(Objects.equals(subject.getId(), subject1.getId())){
                                var check = true;

                                // Kiểm tra sv chưa hoàn thành hoặc chưa học môn học này
                                for (StudyHistoryResponse studyHistory : studyHistories) {
                                    if(
                                            Objects.equals(studyHistory.getSubjectId(), subject.getId())
                                            && studyHistory.getActivityStatus().equals("Chưa hoàn thành")
                                    ){
                                        listSubject.add(subject);
                                        break;
                                    }
                                    else if(Objects.equals(studyHistory.getSubjectId(), subject.getId())){
                                        check = false;
                                        break;
                                    }
                                };

                                if(check)
                                    listSubject.add(subject);
                            }
                        });

                        // Kiểm tra môn học đang mở có trong môn học của chuyên ngành hẹp ko
//                        if(student.getPrivateMajor() != null){
//                            PrivateMajor privateMajor = privateMajorRepository.findById(student.getPrivateMajor().getId())
//                                    .orElseThrow(() -> new AppException(ErrorCode.PRIVATE_MAJOR_NOT_EXISTED));
//                            privateMajor.getSubjects().forEach(subject2 -> {
//                                if(Objects.equals(subject.getId(), subject2.getId())){
//
//                                    var check = true;
//                                    var prerequisiteMet = subject.getRequiredSubject() == null;
//
//                                    // Kiểm tra sv chưa hoàn thành hoặc chưa học môn học này
//                                    for (StudyHistoryResponse studyHistory : studyHistories) {
//                                        if(
//                                                Objects.equals(studyHistory.getSubjectId(), subject.getId())
//                                                        && studyHistory.getActivityStatus().equals("Chưa hoàn thành")
//                                        ){
//                                            listSubject.add(subject);
//                                            break;
//                                        }
//                                        else if(Objects.equals(studyHistory.getSubjectId(), subject.getId())){
//                                            check = false;
//                                            break;
//                                        }
//
//                                        // Kiểm tra môn tiên quyết
//                                        if (subject.getRequiredSubject() != null
//                                                && Objects.equals(studyHistory.getSubjectId(), subject.getRequiredSubject().getId())) {
//                                            prerequisiteMet = true;
//                                            break;
//                                        }
//                                    };
//
//                                    if(studyHistories.size() <= 0 && subject.getRequiredSubject() != null){
//                                        check = false;
//                                    }
//
//                                    if(check && prerequisiteMet)
//                                        listSubject.add(subject);
//                                }
//                            });
//                        }

                        if (student.getPrivateMajor() != null) {
                            PrivateMajor privateMajor = privateMajorRepository.findById(student.getPrivateMajor().getId())
                                    .orElseThrow(() -> new AppException(ErrorCode.PRIVATE_MAJOR_NOT_EXISTED));

                            privateMajor.getSubjects().forEach(subject2 -> {
                                if (Objects.equals(subject.getId(), subject2.getId())) {

                                    boolean prerequisiteMet = subject.getRequiredSubject() == null ||
                                            studyHistories.stream()
                                                    .anyMatch(studyHistory ->
                                                            Objects.equals(studyHistory.getSubjectId(), subject.getRequiredSubject().getId())
                                                                    && studyHistory.getActivityStatus().equals("Hoàn thành")
                                                    );

                                    boolean alreadyCompleted = studyHistories.stream()
                                            .anyMatch(studyHistory ->
                                                    Objects.equals(studyHistory.getSubjectId(), subject.getId())
                                                            && studyHistory.getActivityStatus().equals("Hoàn thành")
                                            );

                                    // Nếu đã hoàn thành môn tiên quyết nhưng chưa hoàn thành môn hiện tại thì mới thêm vào danh sách
                                    if (prerequisiteMet && !alreadyCompleted) {
                                        listSubject.add(subject);
                                    }
                                }
                            });
                        }
                    }
        });

        return listSubject.stream()
                .map(subjectMapper::toSubjectResponse).toList();
    }

    @Override
    public List<SubjectResponse> findRegisteredSubjectBySemesterAndYear() {
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        SemesterProgressResponse semesterProgress = semesterProgressService.getOneByStatusTrue();

        return subjectRepository.findRegisteredSubjectFalseOfStudentBySemesterAndYear(
                semesterProgress.getSubjectSemesterOpen(), semesterProgress.getSubjectYearOpen(), student
        ).stream().map(subjectMapper::toSubjectResponse).toList();
    }

    @Override
    public boolean checkSubjectAndStudentExisted(Subject subject, Student student){
        return student.getStudyIns().stream()
                .anyMatch(studyIn -> studyIn.getClazz().getSubject().getId().equals(subject.getId()));
    }
}
