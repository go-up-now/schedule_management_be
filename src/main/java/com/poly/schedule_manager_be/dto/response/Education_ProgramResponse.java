package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Subject;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

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
//    Set<SubjectResponse> subjects;
}
