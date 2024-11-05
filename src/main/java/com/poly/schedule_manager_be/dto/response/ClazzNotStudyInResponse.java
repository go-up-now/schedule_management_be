package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClazzNotStudyInResponse {
    Integer id;
    String code;
    String onlineLink;
    Integer quantity;
    Integer block;
    String semester;
    Integer year;
    String dayOfWeek;
    LocalDate startTime;
    LocalDate endTime;
    Boolean status;
    SubjectResponse subject;
    String instructorCode;
    Integer shift;
    RoomResponse room;
    String activityStatus;
}
