package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
}
