package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.MajorResponse;
import com.poly.schedule_manager_be.service.MajorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/majors")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MajorController {
    MajorService majorService;

    @GetMapping
    ApiResponse<List<MajorResponse>> getAll(){
        return ApiResponse.<List<MajorResponse>>builder()
                .message("Lấy danh sách ngành học thành công")
                .data(majorService.getAll())
                .build();
    }


}
