package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.InstructorRequest;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.InstructorResponse;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;

import java.util.List;

public interface InstructorService {
    InstructorResponse create(InstructorRequest request);
    InstructorResponse update(InstructorRequest request, Integer id);
    void delete(Integer id);
    InstructorResponse getOne(Integer id);
    List<InstructorResponse> getAll();
    InstructorResponse getInstructorMyInfor();
}
