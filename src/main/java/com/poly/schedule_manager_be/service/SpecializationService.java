package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.response.SpecializationResponse;

import java.util.List;

public interface SpecializationService {
    List<SpecializationResponse> getAll();
}
