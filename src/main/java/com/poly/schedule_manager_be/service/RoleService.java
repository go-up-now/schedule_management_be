package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.RoleRequest;
import com.poly.schedule_manager_be.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse create(RoleRequest request);
    List<RoleResponse> getAll();
    void delete(String role);
}
