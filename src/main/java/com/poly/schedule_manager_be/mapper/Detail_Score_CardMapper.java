package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.response.Detail_Score_CardsResponse;
import com.poly.schedule_manager_be.entity.Detail_Score_Cards;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Detail_Score_CardMapper {
//    Detail_Score_Cards toDetail_Score_Card(AreaRequest request);
    @Mapping(target = "studyHistoryId", source = "studyHistory.id")
    Detail_Score_CardsResponse toDetail_Score_CardsResponse(Detail_Score_Cards detailScoreCards);
}
