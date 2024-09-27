package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clazz")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(unique=true)
    String code;
    String onlineLink;
    Integer quantity;
    Integer block;
    String semester;
    Integer year;
    String dayOfWeek;
    LocalDate startTime;
    LocalDate endTime;
    Boolean status;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id")
    Shift shift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    Room room;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    List<Exam_Schedule> examSchedules;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    List<Student_Exam_Assignment> studentExamAssignments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "students_clazzes", // Tên bảng liên kết
            joinColumns = @JoinColumn(name = "clazz_id"), // Khóa ngoại trỏ đến Clazz
            inverseJoinColumns = @JoinColumn(name = "student_id") // Khóa ngoại trỏ đến Student
    )
    List<Student> students;
}
