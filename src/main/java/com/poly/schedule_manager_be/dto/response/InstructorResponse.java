package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InstructorResponse {
    Integer id;
    String semester;
    String experience;
    Integer year;
    UserResponseDTO user;
    SpecializationResponse specialization;
}
