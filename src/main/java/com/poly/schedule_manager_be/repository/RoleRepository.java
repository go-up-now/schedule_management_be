package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
//    Optional<Role> findByCode(String code);
}
