package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.StudyIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudyInRepository extends JpaRepository<StudyIn, Integer> {
    Optional<StudyIn> findByClazzSemesterAndClazzYearAndClazzSubjectIdAndStudent(String semester, int year, int subjectId, Student student);

    List<StudyIn> findAllByClazzSemesterAndClazzYearAndStudent(String semester, int year, Student student);

    List<StudyIn> findAllByClazzSemesterAndClazzYearAndStatusAndStudent(String semester, int year, boolean status, Student student);
}
