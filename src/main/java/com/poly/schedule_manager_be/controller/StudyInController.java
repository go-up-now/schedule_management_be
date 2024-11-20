package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.StudyInRequest;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.dto.response.StudyInResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.service.StudyInService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study-in")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudyInController {
    StudyInService studyInService;

    // Đăng ký lớp học theo clazz id
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @PostMapping("/registration-clazz")
    ApiResponse<?> clazzRegistration(@RequestBody StudyInRequest request){
        studyInService.registrationClazz(request);
        return ApiResponse.builder()
                .message("Đăng ký lớp học thành công")
                .build();
    }

    // Lấy danh sách lớp học đã đăng ký theo học kỳ và năm học của sinh viên
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @GetMapping("/semester-year")
    ApiResponse<List<StudyInResponse>> getAllBySemesterAndYearAndStudent(){
        return ApiResponse.<List<StudyInResponse>>builder()
                .message("Lấy danh sách lớp học đã đăng ký theo học kỳ và năm học của sinh viên thành công")
                .data(studyInService.getAllBySemetserAndYear())
                .build();
    }

    // Hủy đăng ký lớp học theo môn học
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @DeleteMapping("/subject/{subjectId}")
    ApiResponse<?> deleteBySubject(@PathVariable Integer subjectId){
        studyInService.delete(subjectId);
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Hủy đăng ký lớp học thành công")
                .build();
    }

    // Cập nhật trạng thái true cho môn học đã đăng ký của sinh viên sau khi thanh toán thành công
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @PutMapping("/update-status")
    ApiResponse<?> updateStatus(){
        studyInService.updateStudyInStatusTrue();
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Cập nhật trạng thái true cho môn học đã đăng ký của sinh viên theo học kỳ và năm học thành công")
                .build();
    }
}
