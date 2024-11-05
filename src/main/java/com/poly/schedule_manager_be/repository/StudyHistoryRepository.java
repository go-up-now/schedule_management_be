package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.Study_History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyHistoryRepository extends JpaRepository<Study_History, Integer> {
    List<Study_History> findAllBySemesterAndYearAndStudentAndActivityStatus(String semester, Integer year, Student student, String activityStatus);
    List<Study_History> findAllByStudent(Student student);
}
