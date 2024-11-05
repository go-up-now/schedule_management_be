package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "semester_progress")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SemesterProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String subjectSemesterOpen;
    Integer subjectYearOpen;
    Boolean status;
    LocalDateTime timeStart;
    LocalDateTime timeEnd;
}
