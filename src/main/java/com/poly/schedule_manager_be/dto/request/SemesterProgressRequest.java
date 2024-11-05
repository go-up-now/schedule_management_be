package com.poly.schedule_manager_be.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SemesterProgressRequest {
    String subjectSemesterOpen;
    Integer subjectYearOpen;
}
