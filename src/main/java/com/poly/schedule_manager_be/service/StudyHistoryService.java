package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.response.StudyHistoryResponse;

import java.util.List;

public interface StudyHistoryService {
    List<StudyHistoryResponse> getAllByStudent();
}
