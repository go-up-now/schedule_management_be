package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.response.StudyHistoryResponse;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.User;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.StudyHistoryMapper;
import com.poly.schedule_manager_be.repository.StudentRepository;
import com.poly.schedule_manager_be.repository.StudyHistoryRepository;
import com.poly.schedule_manager_be.service.AuthenticationService;
import com.poly.schedule_manager_be.service.StudyHistoryService;
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
public class StudyHistoryServiceImpl implements StudyHistoryService {

    StudyHistoryRepository studyHistoryRepository;
    AuthenticationService authenticationService;
    StudentRepository studentRepository;
    StudyHistoryMapper studyHistoryMapper;

    @Override
    public List<StudyHistoryResponse> getAllByStudent() {
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        return studyHistoryRepository.findAllByStudent(student)
                .stream().map(studyHistoryMapper::toStudyHistoryResponseResponse).toList();
    }

    @Override
    public List<Map<String, Object>> getAllStudyHistoryByStudent() {
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        return studyHistoryRepository.findAllStudyHistoryByStudent(student);
    }
}
