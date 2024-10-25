package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Instructor;
import com.poly.schedule_manager_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Optional<Instructor> findByUser(User user);
    Optional<Instructor> findByUserCode(String code);
    List<Instructor> findAllByUserAreaId(Integer areaId);
}
