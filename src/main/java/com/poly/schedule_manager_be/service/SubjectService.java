package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.SubjectRequest;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SubjectService {
    SubjectResponse create(SubjectRequest request);
    SubjectResponse update(SubjectRequest request, Integer id);
    void delete(Integer id);
    SubjectResponse getOne(Integer id);
    List<SubjectResponse> getAll();
    List<SubjectResponse> findSubjectBySemesterAndYear(String semester, int year);
}
