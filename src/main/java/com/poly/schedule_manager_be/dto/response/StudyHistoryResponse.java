package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Detail_Score_Cards;
import com.poly.schedule_manager_be.entity.Mark_Column;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.Subject;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudyHistoryResponse {
    Integer id;
    String semester;
    Integer year;
    Integer block;
    Boolean status;
    Double averageScore;
    LocalDate dateSuccess;
    String activityStatus;
    Integer studentId;
    Integer subjectId;

}
