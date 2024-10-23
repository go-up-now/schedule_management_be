package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Area;
import com.poly.schedule_manager_be.entity.Instructor;
import com.poly.schedule_manager_be.entity.Major;
import com.poly.schedule_manager_be.entity.Subject;
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
public class SpecializationResponse {
    String code;
    String name;
    Boolean status;
    AreaResponse area;
}
