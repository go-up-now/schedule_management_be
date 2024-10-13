package com.poly.schedule_manager_be.dto.response;

import com.poly.schedule_manager_be.entity.Area;
import com.poly.schedule_manager_be.entity.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDTO {
    Integer id;
    String code;
    String firstName;
    String lastName;
    String email;
    Integer gender;
    LocalDate birthday;
    String phone;
    String address;
    String description;
    String avatar;
    Boolean status;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime updatedAt;
    String updatedBy;
    Set<Role> roles;
    AreaResponse area;
}
