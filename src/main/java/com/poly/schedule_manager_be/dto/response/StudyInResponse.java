package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudyInResponse {
    Integer id;
    Boolean status;
    LocalDateTime createdAt;
    String clazzCode;
    Integer subjectId;
    Integer studentId;
}
