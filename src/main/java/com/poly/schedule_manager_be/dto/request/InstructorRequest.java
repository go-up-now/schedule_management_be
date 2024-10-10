package com.poly.schedule_manager_be.dto.request;

import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Specialization;
import com.poly.schedule_manager_be.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InstructorRequest {
    String semester;
    String experience;
    Integer year;
    User user;
    String specialization;
}
