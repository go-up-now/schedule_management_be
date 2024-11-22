package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.Study_History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface StudyHistoryRepository extends JpaRepository<Study_History, Integer> {
    List<Study_History> findAllByStudyInStudent(Student student);

    @Query("SELECT sh.id as id, c.semester as semester, c.year as year, c.block as block ,COALESCE(sh.averageScore, 0.0) as averageScore, " +
            "c.subject.code as subjectCode, c.subject.name as name, c.subject.credits as credits, sh.activityStatus as activityStatus, " +
            "c.code as clazzCode, c.instructor.user.code as instructor " +
            "FROM Study_History sh " +
            "JOIN StudyIn si ON si = sh.studyIn " +
            "JOIN Clazz c ON c = si.clazz " +
            "WHERE si.student = :student " +
            "AND si.status = true " +
            "ORDER BY c.year DESC")
    List<Map<String, Object>> findAllStudyHistoryByStudent(@Param("student") Student student);
}
