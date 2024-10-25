package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.response.ShiftResponse;

import java.util.List;

public interface ShiftService {
    List<ShiftResponse> getAll();
}
