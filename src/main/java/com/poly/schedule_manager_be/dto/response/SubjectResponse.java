package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Specialization;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;
    Integer requiredSubjectID;
    Set<Specialization> specializations;
//    List<ClazzNotStudentResponseDTO> clazzes;
}
