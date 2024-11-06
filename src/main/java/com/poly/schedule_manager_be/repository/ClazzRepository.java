package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Shift;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    boolean existsByCode(String code);
    List<Clazz> findAllBySemesterAndYearAndSubject(String semester,Integer year, Subject subject);
    Optional<Clazz> findByCode(String code);

//    List<Clazz> findAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc(Student student, LocalDate startTime, LocalDate startTime2, LocalDate endTime, LocalDate endTime2);
@Query("SELECT c FROM Clazz c " +
        "JOIN StudyIn si ON si.clazz = c " +
        "WHERE si.student = :student " +
        "AND (c.startTime BETWEEN :startTime AND :startTime2 " +
        "     OR c.endTime BETWEEN :endTime AND :endTime2) " +
        "AND si.status = true " +
        "ORDER BY c.startTime ASC")
List<Clazz> findAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc(@Param("student") Student student,
                                                                                           @Param("startTime") LocalDate startTime,
                                                                                           @Param("startTime2") LocalDate startTime2,
                                                                                           @Param("endTime") LocalDate endTime,
                                                                                           @Param("endTime2") LocalDate endTime2);
}
