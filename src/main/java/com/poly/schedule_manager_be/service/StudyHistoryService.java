package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.response.StudyHistoryResponse;

import java.util.List;
import java.util.Map;

public interface StudyHistoryService {
    List<StudyHistoryResponse> getAllByStudent();
//    List<Map<String, Object>> getAllStudyHistoryByStudent();
}
