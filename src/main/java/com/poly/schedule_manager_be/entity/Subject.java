package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    String code;
    String name;
    String credits;
    String description;
    Double cost;
    Boolean status;
    String subjectType;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;

    @OneToOne
    @JoinColumn(name = "required")
    Subject requiredSubject;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "subject_group_id")
//    Subject_Group subject_group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization_code")
    Specialization specialization;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    List<Clazz> clazzes;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    List<Study_History> studyHistories;
}
