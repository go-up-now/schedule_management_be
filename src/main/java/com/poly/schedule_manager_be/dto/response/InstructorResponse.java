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
    String semester;
    String experience;
    Integer year;
    User user;
    String specialization;
}
