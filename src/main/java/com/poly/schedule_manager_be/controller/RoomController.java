package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.RoomResponse;
import com.poly.schedule_manager_be.dto.response.SpecializationResponse;
import com.poly.schedule_manager_be.service.RoomService;
import com.poly.schedule_manager_be.service.SpecializationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomController {
    RoomService roomService;

    @GetMapping
    ApiResponse<List<RoomResponse>> getAll(){
        return ApiResponse.<List<RoomResponse>>builder()
                .message("Lấy danh sách phòng học thành công")
                .data(roomService.getAll())
                .build();
    }

    @GetMapping("/{areaId}")
    ApiResponse<List<RoomResponse>> getAllByBuildingAreaId(@PathVariable Integer areaId){
        return ApiResponse.<List<RoomResponse>>builder()
                .message("Lấy danh sách phòng học theo khu vực thành công")
                .data(roomService.getAllByBuildingAreaId(areaId))
                .build();
    }
}
