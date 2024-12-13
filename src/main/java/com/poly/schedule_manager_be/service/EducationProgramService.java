package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.Education_ProgramRequest;
import com.poly.schedule_manager_be.dto.response.Education_ProgramResponse;

import java.util.List;
import java.util.Map;

public interface EducationProgramService {
    Education_ProgramResponse create(Education_ProgramRequest request);
    Education_ProgramResponse update(Education_ProgramRequest request, String code);
    void delete(String code);
    Education_ProgramResponse getOne(String code);
    List<Education_ProgramResponse> getAll();
}
