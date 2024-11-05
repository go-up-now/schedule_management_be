package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "subject_mark_column")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectMarkColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String subjectType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_column_id")
    Mark_Column markColumn;
}
