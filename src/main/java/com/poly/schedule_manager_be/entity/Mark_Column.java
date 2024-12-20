package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mark_column")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mark_Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Double percentage;

    @OneToMany(mappedBy = "markColumn")
    List<Detail_Score_Cards> detailScoreCards;

    @OneToMany(mappedBy = "markColumn")
    List<SubjectMarkColumn> subjectMarkColumns;
}
