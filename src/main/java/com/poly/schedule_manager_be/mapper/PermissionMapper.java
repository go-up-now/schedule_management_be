package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.PermissionRequest;
import com.poly.schedule_manager_be.dto.response.PermissionResponse;
import com.poly.schedule_manager_be.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
