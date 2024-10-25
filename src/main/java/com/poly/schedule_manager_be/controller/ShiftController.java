package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.RoomResponse;
import com.poly.schedule_manager_be.dto.response.ShiftResponse;
import com.poly.schedule_manager_be.service.RoomService;
import com.poly.schedule_manager_be.service.ShiftService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShiftController {
    ShiftService shiftService;

    @GetMapping
    ApiResponse<List<ShiftResponse>> getAll(){
        return ApiResponse.<List<ShiftResponse>>builder()
                .message("Lấy danh sách ca học thành công")
                .data(shiftService.getAll())
                .build();
    }
}
