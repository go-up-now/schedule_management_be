package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.RoleRequest;
import com.poly.schedule_manager_be.dto.response.RoleResponse;
import com.poly.schedule_manager_be.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
