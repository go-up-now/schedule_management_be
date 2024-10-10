package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import com.poly.schedule_manager_be.entity.Subject;
import com.poly.schedule_manager_be.service.SubjectService;
import com.poly.schedule_manager_be.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{semester}/{year}/{studentId}")
    ApiResponse<List<SubjectResponse>> getAllSubjectBySemesterAndYear(
            @PathVariable String semester, @PathVariable int year, @PathVariable int studentId){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học theo năm và học kỳ của sinh viên thành công")
                .data(subjectService.findSubjectBySemesterAndYear(semester, year, studentId))
                .build();
    }

    @GetMapping("/registered/{semester}/{year}/{studentId}")
    ApiResponse<List<SubjectResponse>> getAllRegisteredSubjectBySemesterAndYear(
            @PathVariable String semester, @PathVariable int year, @PathVariable int studentId){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học đã đăng ký theo năm và học kỳ của sinh viên thành công")
                .data(subjectService.findRegisteredSubjectBySemesterAndYear(semester, year, studentId))
                .build();
    }
}
