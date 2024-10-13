package com.poly.schedule_manager_be.dto.request;

import com.poly.schedule_manager_be.entity.Major;
import com.poly.schedule_manager_be.entity.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Education_ProgramRequest {
    String code;
    String name;
    String semester;
    Integer year;
    Boolean status;
    Integer major;
}
