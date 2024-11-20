package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.StudyInResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubjectController {
    SubjectService subjectService;

    @GetMapping
    ApiResponse<List<SubjectResponse>> getAll(){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học thành công")
                .data(subjectService.getAll())
                .build();
    }

    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @GetMapping("/by-semester-year")
    ApiResponse<List<SubjectResponse>> getAllSubjectBySemesterAndYear(){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học theo năm và học kỳ đang mở của sinh viên thành công")
                .data(subjectService.findSubjectBySemesterAndYear())
                .build();
    }

    // Lấy danh sách môn học đã đăng ký nhưng chưa thanh toán theo năm và học kỳ của sinh viên
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @GetMapping("/registered")
    ApiResponse<List<SubjectResponse>> getAllRegisteredSubjectBySemesterAndYear(){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học đã đăng ký nhưng chưa thanh toán theo năm và học kỳ của sinh viên thành công")
                .data(subjectService.findRegisteredSubjectBySemesterAndYear())
                .build();
    }
}
