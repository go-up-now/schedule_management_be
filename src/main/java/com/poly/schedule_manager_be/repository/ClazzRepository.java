package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    boolean existsByCode(String code);
}
