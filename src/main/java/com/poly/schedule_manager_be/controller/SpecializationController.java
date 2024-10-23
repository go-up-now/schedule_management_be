package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.SpecializationResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.service.SpecializationService;
import com.poly.schedule_manager_be.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specializations")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SpecializationController {
    SpecializationService specializationService;

    @GetMapping
    ApiResponse<List<SpecializationResponse>> getAll(){
        return ApiResponse.<List<SpecializationResponse>>builder()
                .message("Lấy danh sách bộ môn thành công")
                .data(specializationService.getAll())
                .build();
    }
}
