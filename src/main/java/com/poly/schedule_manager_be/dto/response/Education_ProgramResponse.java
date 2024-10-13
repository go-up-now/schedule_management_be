package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Education_ProgramResponse {
    String code;
    String name;
    String semester;
    Integer year;
    Boolean status;
    MajorResponse major;
}
