package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.PermissionRequest;
import com.poly.schedule_manager_be.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    PermissionResponse create(PermissionRequest request);
    List<PermissionResponse> getAll();
    void delete(String permission);
}
