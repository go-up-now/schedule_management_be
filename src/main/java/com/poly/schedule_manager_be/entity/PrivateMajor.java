package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "private_majors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String code;
    String name;
    Boolean status;
    LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    Major major;

    @ManyToMany
    @JoinTable(
            name = "private_majors_subjects", // Tên bảng liên kết
            joinColumns = @JoinColumn(name = "private_major_id"),
            inverseJoinColumns = @JoinColumn(name = "subjects_id")
    )
    Set<Subject> subjects;
}
