package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Education_Program;
import com.poly.schedule_manager_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EducationProgramRepository extends JpaRepository<Education_Program, String> {
    Optional<Education_Program> findByCode(String code);
}
