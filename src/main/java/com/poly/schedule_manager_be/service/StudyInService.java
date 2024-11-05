package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.StudyInRequest;
import com.poly.schedule_manager_be.dto.response.StudyInResponse;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Student;

import java.util.List;

public interface StudyInService {
    StudyInResponse registrationClazz(StudyInRequest request);
    void delete(Integer subjectId);
    StudyInResponse getOne(Integer id);
    List<StudyInResponse> getAllBySemetserAndYear();
    long countByStudentsInClazz(Clazz clazz);
}
