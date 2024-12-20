package com.poly.schedule_manager_be.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateRequestDTO {
    String firstName;
    String lastName;
    @Size(min = 5, message = "PASSWORD_INVALID")
    String password;
    Integer gender;
    LocalDate birthday;
    String phone;
    String address;
    String description;
//    String avatar;
    Boolean status;
    Set<String> roles;
    Integer area;
    LocalDateTime updatedAt = LocalDateTime.now();
    String updatedBy;
}
