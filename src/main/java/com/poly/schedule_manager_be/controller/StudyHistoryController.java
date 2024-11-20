package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.service.StudyHistoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study-histories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudyHistoryController {
    StudyHistoryService studyHistoryService;

    // Lấy danh sách lịch sử học tập của sinh viên
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @GetMapping("/student")
    ApiResponse<?> getAllStudyHistoryByStudent(){
        return ApiResponse.builder()
                .message("Lấy danh sách lịch sử học tập của sinh viên thành công")
//                .data(studyHistoryService.getAllStudyHistoryByStudent())
                .build();
    }
}
