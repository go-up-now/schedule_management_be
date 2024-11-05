package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "study_history")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Study_History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String semester;
    Integer year;
    Integer block;
    Boolean status;
    Double averageScore;
    LocalDate dateSuccess;
    String activityStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    Subject subject;

    @ManyToMany
    Set<Mark_Column> markColumns;

    @OneToMany(mappedBy = "studyHistory")
    List<Detail_Score_Cards> detailScoreCards;
}
