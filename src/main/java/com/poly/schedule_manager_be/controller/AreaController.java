package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.service.AreaService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AreaController {
    AreaService areaService;

    @GetMapping
    ApiResponse<List<AreaResponse>> getAll(){
        return ApiResponse.<List<AreaResponse>>builder()
                .message("Lấy danh sách khu vực thành công")
                .data(areaService.getAll())
                .build();
    }


}
