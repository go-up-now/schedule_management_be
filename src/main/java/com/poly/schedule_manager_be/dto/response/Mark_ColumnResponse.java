package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mark_ColumnResponse {
    Integer id;
    String name;
    Double percentage;
}
