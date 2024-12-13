package com.poly.schedule_manager_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "education_program")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Education_Program {
    @Id
    String code;
    String name;
    String semester;
    Integer year;
    Boolean status;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;

    @OneToMany(mappedBy = "education_program", cascade = CascadeType.ALL)
    List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    Major major;

    @ManyToMany
    @JoinTable(
            name = "education_program_subjects", // Tên bảng liên kết
            joinColumns = @JoinColumn(name = "education_program_code"),
            inverseJoinColumns = @JoinColumn(name = "subjects_id")
    )
    Set<Subject> subjects;
}
