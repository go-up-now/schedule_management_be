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

//    @Query("SELECT sh.id as id, sh.semester as semester, sh.year as year, sh.block as block ,COALESCE(sh.averageScore, 0.0) as averageScore, " +
//            "s.code as subjectCode, s.name as name, s.credits as credits, sh.activityStatus as activityStatus, " +
//            "c.code as clazzCode, c.instructor.user.code as instructor " +
//            "FROM Study_History sh " +
//            "JOIN Subject s ON s = sh.subject " +
//            "JOIN Student sd ON sh.student = sd " +
//            "JOIN StudyIn si ON si.student = sd " +
//            "JOIN Clazz c ON c = si.clazz " +
//            "WHERE sh.student = :student " +
//            "AND c.semester = sh.semester AND c.year = sh.year AND c.block = sh.block " +
//            "AND c.subject.id = sh.subject.id AND si.status = true " +
//            "ORDER BY sh.year DESC")
//    List<Map<String, Object>> findAllStudyHistoryByStudent(@Param("student") Student student);
}
