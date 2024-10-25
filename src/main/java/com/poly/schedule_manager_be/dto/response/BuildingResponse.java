package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Area;
import com.poly.schedule_manager_be.entity.Room;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingResponse {
    Integer id;
    String name;
    String address;
    AreaResponse area;
}
