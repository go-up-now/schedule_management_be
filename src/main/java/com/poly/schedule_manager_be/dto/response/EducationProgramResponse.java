package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Major;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationProgramResponse {
    String code;
    String name;
    String semester;
    Integer year;
    Boolean status;
    MajorResponse major;
}
