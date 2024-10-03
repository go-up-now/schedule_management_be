package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.SubjectRequest;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.mapper.ClazzMapper;
import com.poly.schedule_manager_be.mapper.SubjectMapper;
import com.poly.schedule_manager_be.repository.*;
import com.poly.schedule_manager_be.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    SubjectRepository subjectRepository;
    SubjectMapper subjectMapper;


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
    public List<SubjectResponse> findSubjectBySemesterAndYear(String semester, int year) {
        return subjectRepository.findSubjectBySemesterAndYear(semester, year)
                .stream().map(subjectMapper::toSubjectResponse).toList();
    }
}
