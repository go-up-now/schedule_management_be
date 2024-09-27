package com.poly.schedule_manager_be.dto.request;

import com.poly.schedule_manager_be.entity.Area;
import com.poly.schedule_manager_be.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class UserCreateRequestDTO {
    @NotBlank(message = "CODE_NOT_BLANK")
    String code;
    String firstName;
    String lastName;
    @NotBlank(message = "EMAIL_INVALID")
    String email;
    @NotBlank(message = "PASSWORD_NOT_BLANK")
    @Size(min = 5, message = "PASSWORD_INVALID")
    String password;
    Integer gender;
    LocalDate birthday;
    String phone;
    String address;
    String description;
    String avatar;
    Boolean status = true;
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy;
}
