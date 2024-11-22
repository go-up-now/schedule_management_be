package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.response.Detail_Score_CardsResponse;

import java.util.List;

public interface DetailScoreCardService {
    List<Detail_Score_CardsResponse> getAllByStudyHistoryId(Integer studyHistoryId);
}
