package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.dto.response.Detail_Score_CardsResponse;
import com.poly.schedule_manager_be.service.AreaService;
import com.poly.schedule_manager_be.service.DetailScoreCardService;
import com.poly.schedule_manager_be.service.impl.DetailScoreCardServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/detail-score-card")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DetailScoreCardController {
    DetailScoreCardService detailScoreCardService;

    @GetMapping("/{studyHistoryId}")
        ApiResponse<List<Detail_Score_CardsResponse>> getAllByStudyHistoryId(
                                                    @PathVariable Integer studyHistoryId){
        return ApiResponse.<List<Detail_Score_CardsResponse>>builder()
                .message("Lấy danh sách bảng điểm chi tiết theo lịch sử học tập của sinh viên thành công")
                .data(detailScoreCardService.getAllByStudyHistoryId(studyHistoryId))
                .build();
    }


}
