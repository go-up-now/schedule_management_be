package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MajorResponse {
    Integer id;
    String code;
    String name;
    Boolean status;
}
