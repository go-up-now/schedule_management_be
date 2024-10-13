package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Area;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Integer> {
}
