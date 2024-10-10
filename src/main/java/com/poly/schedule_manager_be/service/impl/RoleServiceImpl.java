package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.RoleRequest;
import com.poly.schedule_manager_be.dto.response.RoleResponse;
import com.poly.schedule_manager_be.mapper.RoleMapper;
import com.poly.schedule_manager_be.repository.PermissionRepository;
import com.poly.schedule_manager_be.repository.RoleRepository;
import com.poly.schedule_manager_be.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    @Override
    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAll() {
        roleRepository.findAll().forEach(role -> {
            System.out.println("------------------------------------------------------------------");
            System.out.println(role.getPermissions());
        });


        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }
    @Override
    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
