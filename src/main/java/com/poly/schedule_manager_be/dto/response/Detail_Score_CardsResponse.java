package com.poly.schedule_manager_be.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Detail_Score_CardsResponse {
    Integer id;
    Double mark;
    Integer studyHistoryId;
    Mark_ColumnResponse markColumn;
}
