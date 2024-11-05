package com.poly.schedule_manager_be.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "detail_score_cards")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Detail_Score_Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_history_id")
    Study_History studyHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    Mark_Column markColumn;
}
