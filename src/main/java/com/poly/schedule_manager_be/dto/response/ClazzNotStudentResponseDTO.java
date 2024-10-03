package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Subject;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClazzNotStudentResponseDTO {
    Integer id;
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
    Integer subjectID;
    Integer instructorID;
    Integer shiftID;
    Integer roomID;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;
}
