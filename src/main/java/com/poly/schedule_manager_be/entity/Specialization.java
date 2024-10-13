package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "specializations")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Specialization {
    @Id
    String code;
    String name;
    Boolean status;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    Area area;

    @OneToMany(mappedBy = "specialization")
    List<Major> majors;

    @OneToMany(mappedBy = "specialization")
    List<Instructor> instructors;

    @ManyToMany
    Set<Subject> subjects;
}
