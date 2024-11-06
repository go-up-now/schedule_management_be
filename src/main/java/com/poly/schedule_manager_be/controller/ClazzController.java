package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.service.ClazzService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/classes")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ClazzController {
    ClazzService clazzService;

    @PostMapping
    ApiResponse<ClazzResponseDTO> create(@RequestBody @Valid ClazzRequestDTO requestDTO){
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Thêm lớp học thành công")
                .data(clazzService.create(requestDTO))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<ClazzResponseDTO> update(@RequestBody @Valid ClazzRequestDTO requestDTO,
                                        @PathVariable Integer id){
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Sửa lớp học thành công")
                .data(clazzService.update(requestDTO, id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<?> delete(@PathVariable Integer id){
        clazzService.delete(id);
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Xóa lớp học thành công")
                .build();
    }

    @PostMapping("/import")
    ApiResponse<?> importExcel(@RequestBody @Valid List<ClazzRequestDTO> requestDTO){
        clazzService.importClazz(requestDTO);
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Import excel lớp học thành công")
                .build();
    }

    @GetMapping
    ApiResponse<List<ClazzResponseDTO>> getAllClazzExcludeStudent(){
        return ApiResponse.<List<ClazzResponseDTO>>builder()
                .message("Lấy danh sách lớp học loại trừ sinh viên thành công")
                .data(clazzService.getAll())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<ClazzResponseDTO> getOne(@PathVariable Integer id){
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Lấy lớp học thành công")
                .data(clazzService.getOne(id))
                .build();
    }

    // Lấy danh sách lớp học theo môn học, học kỳ và năm học nhưng loại trừ sinh viên
    @GetMapping("/subject/{subjectId}")
    ApiResponse<List<ClazzResponseDTO>> getAllClazzBySubjectId(@PathVariable Integer subjectId){
        return ApiResponse.<List<ClazzResponseDTO>>builder()
                .message("Lấy danh sách lớp theo môn học, học kỳ và năm học thành công")
                .data(clazzService.getAllClazzBySemesterAndYearAndSubject(subjectId))
                .build();
    }

    // Lấy thông tin lớp học theo môn học
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @GetMapping("/infor-detail/{subjectId}")
    ApiResponse<ClazzResponseDTO> getInforDetailBySubject(@PathVariable Integer subjectId){
        return ApiResponse.<ClazzResponseDTO>builder()
                .message("Lấy thông tin lớp học theo môn học thành công")
                .data(clazzService.getInforDetailBySubject(subjectId))
                .build();
    }

    // Lấy danh sách lớp học mà sinh viên đã đăng ký từ 30 trước đến 30 ngày sau
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    @GetMapping("/studyin-student")
    ApiResponse<List<ClazzResponseDTO>> getAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc(){
        return ApiResponse.<List<ClazzResponseDTO>>builder()
                .message("Lấy danh sách lớp học mà sinh viên đã đăng ký từ 30 trước đến 30 ngày sau thành công")
                .data(clazzService.findAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc())
                .build();
    }
}
