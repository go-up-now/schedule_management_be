package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.EducationProgramResponse;
import com.poly.schedule_manager_be.service.impl.EducationProgramService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/education-programs")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EducationProgramController {
    EducationProgramService educationProgramService;

    @GetMapping
    ApiResponse<List<EducationProgramResponse>> getAll(){
        return ApiResponse.<List<EducationProgramResponse>>builder()
                .message("Lấy danh sách chương trình đào tạo thành công")
                .data(educationProgramService.getAll())
                .build();
    }


}
