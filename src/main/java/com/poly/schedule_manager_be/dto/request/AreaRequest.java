package com.poly.schedule_manager_be.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AreaRequest {
    Integer id;
    String name;
    Boolean status;
}