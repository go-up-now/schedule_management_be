package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.SubjectRequest;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.Subject;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.ClazzMapper;
import com.poly.schedule_manager_be.mapper.SubjectMapper;
import com.poly.schedule_manager_be.repository.*;
import com.poly.schedule_manager_be.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;
    SubjectMapper subjectMapper;
    StudentRepository studentRepository;
    private final ClazzRepository clazzRepository;


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
    public List<SubjectResponse> findSubjectBySemesterAndYear(String semester, int year, int studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        
        List<Subject> listSubject = new ArrayList<>();

        subjectRepository.findSubjectBySemesterAndYear(semester, year).stream().forEach(subject -> {
            if(!checkSubjectExisted(subject, student))
                listSubject.add(subject);
        });

        return listSubject.stream()
                .map(subjectMapper::toSubjectResponse).toList();
//        return subjectRepository.findSubjectBySemesterAndYear(semester, year)
//                .stream().map(subjectMapper::toSubjectResponse).toList();
    }

    @Override
    public List<SubjectResponse> findRegisteredSubjectBySemesterAndYear(String semester, int year, int studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        List<Subject> listSubject = new ArrayList<>();

        subjectRepository.findSubjectBySemesterAndYear(semester, year).stream().forEach(subject -> {
            if(checkSubjectExisted(subject, student))
                listSubject.add(subject);
        });

        return listSubject.stream()
                .map(subjectMapper::toSubjectResponse).toList();
    }

    @Override
    public boolean checkSubjectExisted(Subject subject, Student student){
//        return student.getClazzes().stream()
//                .anyMatch(clazz1 -> clazz1.getSubject().getId().equals(subject.getId()));
        return true;
    }
}
