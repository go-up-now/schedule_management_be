package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.response.Detail_Score_CardsResponse;
import com.poly.schedule_manager_be.entity.Study_History;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.Detail_Score_CardMapper;
import com.poly.schedule_manager_be.repository.DetailScoreCardRepository;
import com.poly.schedule_manager_be.repository.StudyHistoryRepository;
import com.poly.schedule_manager_be.service.DetailScoreCardService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DetailScoreCardServiceImpl implements DetailScoreCardService {

    DetailScoreCardRepository detailScoreCardRepository;
    StudyHistoryRepository studyHistoryRepository;
    Detail_Score_CardMapper detail_Score_CardMapper;

    @Override
    public List<Detail_Score_CardsResponse> getAllByStudyHistoryId(Integer studyHistoryId) {
        Study_History studyHistory = studyHistoryRepository.findById(studyHistoryId).orElseThrow(()->
                new AppException(ErrorCode.STUDY_HISTORY_NOT_EXISTED));

        return detailScoreCardRepository.findAllByStudyHistory(studyHistory).stream()
                .map(detail_Score_CardMapper::toDetail_Score_CardsResponse).toList();
    }
}
