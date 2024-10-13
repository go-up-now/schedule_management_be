package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.request.Education_ProgramRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.dto.response.EducationProgramResponse;

import java.util.List;

public interface EducationProgramService {
    EducationProgramResponse create(Education_ProgramRequest request);
    EducationProgramResponse update(Education_ProgramRequest request, String code);
    void delete(String code);
    EducationProgramResponse getOne(String code);
    List<EducationProgramResponse> getAll();
}
