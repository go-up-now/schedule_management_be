package com.poly.schedule_manager_be.dto.request;

import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudyInRequest {
    Integer clazzId;
    Boolean status = false;
    LocalDateTime createdAt = LocalDateTime.now();
}
