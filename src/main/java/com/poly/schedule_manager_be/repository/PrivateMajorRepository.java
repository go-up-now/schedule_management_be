package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.PrivateMajor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivateMajorRepository extends JpaRepository<PrivateMajor, Integer> {
    Optional<PrivateMajor> findById(Integer integer);
}
