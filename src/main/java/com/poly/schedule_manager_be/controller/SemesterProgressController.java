package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;
import com.poly.schedule_manager_be.service.AreaService;
import com.poly.schedule_manager_be.service.SemesterProgressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/semester-progress")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SemesterProgressController {
    SemesterProgressService semesterProgressService;

    @GetMapping("/status-true")
    ApiResponse<SemesterProgressResponse> getOneByStatusTrue(){
        return ApiResponse.<SemesterProgressResponse>builder()
                .message("Lấy tiến trình đang mở thành công")
                .data(semesterProgressService.getOneByStatusTrue())
                .build();
    }


}
