package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, String> {
}
