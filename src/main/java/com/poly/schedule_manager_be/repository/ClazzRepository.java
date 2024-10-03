package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    boolean existsByCode(String code);
    List<Clazz> findAllBySubject(Subject subject);
}
