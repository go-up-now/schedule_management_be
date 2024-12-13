package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.StudyIn;
import com.poly.schedule_manager_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query("SELECT s FROM Subject s JOIN s.clazzes c WHERE c.semester = :semester AND c.year = :year")
    List<Subject> findSubjectBySemesterAndYear(@Param("semester") String semester, @Param("year") int year);
    Optional<Subject> findByCode(String code);

    @Query("SELECT sj FROM StudyIn s JOIN s.clazz c JOIN c.subject sj " +
            "WHERE c.semester = :semester AND c.year = :year " +
            "AND s.status = false AND s.student = :student ")
    List<Subject> findRegisteredSubjectFalseOfStudentBySemesterAndYear(@Param("semester") String semester,
                                                             @Param("year") int year,
                                                             @Param("student") Student student);
    @Query("SELECT DISTINCT  s " +
            "FROM Subject s " +
            "LEFT JOIN s.privateMajors pm " +
            "LEFT JOIN s.educationPrograms ep " +
            "WHERE pm.name = :privateMajorName")
    List<Subject> findSubjectsInPrivateMajorsAndEducationPrograms(@Param("privateMajorName") String privateMajorName);
}
