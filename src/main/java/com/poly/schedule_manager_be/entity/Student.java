package com.poly.schedule_manager_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    LocalDate enterSchool;
    String semester;
    Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_program_code")
    Education_Program education_program;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Study_History> studyHistories;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Join_Event> joinEvents;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Student_Exam_Assignment> studentExamAssignments;

//    @ManyToMany(fetch = FetchType.LAZY)
//    List<Clazz> clazzes;
}
