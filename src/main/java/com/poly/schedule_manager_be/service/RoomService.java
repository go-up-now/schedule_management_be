package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.response.RoomResponse;
import com.poly.schedule_manager_be.dto.response.SpecializationResponse;

import java.util.List;

public interface RoomService {
    List<RoomResponse> getAll();
}
