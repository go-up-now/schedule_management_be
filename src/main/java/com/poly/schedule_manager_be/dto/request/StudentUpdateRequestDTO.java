package com.poly.schedule_manager_be.dto.request;

import com.poly.schedule_manager_be.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpdateRequestDTO {
    LocalDate enterSchool;
    String semester;
    Integer year;
    UserUpdateRequestDTO user;
}
