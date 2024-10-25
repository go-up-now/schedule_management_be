package com.poly.schedule_manager_be.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.schedule_manager_be.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClazzRequestDTO {
    @NotBlank(message = "CODE_NOT_BLANK")
    String code;
    String onlineLink;
    Integer quantity;
    Integer block;
    String semester;
    Integer year;
    String dayOfWeek;
    LocalDate startTime;
    LocalDate endTime;
    Boolean status = true;
    String subject;
    String instructorCode;
    Integer shift;
    String room;
    String activityStatus = "Chưa hoạt động";
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy;
}
