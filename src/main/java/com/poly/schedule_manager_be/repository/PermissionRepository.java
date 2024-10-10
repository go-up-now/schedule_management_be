package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
