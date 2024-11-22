package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.entity.Education_Program;
import com.poly.schedule_manager_be.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponseDTO {
    Integer id;
    LocalDate enterSchool;
    String semester;
    Integer year;
    Education_ProgramResponse education_program;
    UserResponseDTO user;
    String privateMajorName;
}
