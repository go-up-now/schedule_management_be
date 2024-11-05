package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.SemesterProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SemesterProgressRepository extends JpaRepository<SemesterProgress, Integer> {
    Optional<SemesterProgress> findByStatus(boolean status);
}
