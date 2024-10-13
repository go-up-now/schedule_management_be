package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AreaResponse {
    Integer id;
    String name;
    Boolean status;
}
