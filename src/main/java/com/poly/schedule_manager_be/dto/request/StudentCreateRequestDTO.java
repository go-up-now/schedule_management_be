package com.poly.schedule_manager_be.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.schedule_manager_be.entity.Education_Program;
import com.poly.schedule_manager_be.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentCreateRequestDTO {
    LocalDate enterSchool;
    String semester;
    Integer year;
    String education_program;
    UserCreateRequestDTO user;
}
