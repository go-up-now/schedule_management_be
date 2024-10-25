package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectResponse {
    Integer id;
    String code;
    String name;
    String credits;
    String description;
    Double cost;
    Boolean status;
    Integer requiredSubjectID;
    SpecializationResponse specialization;
//    Set<Specialization> specializations;
//    List<ClazzNotStudentResponseDTO> clazzes;
}
