package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.ClazzNotStudentResponseDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.service.ClazzService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

    @GetMapping
    ApiResponse<List<ClazzNotStudentResponseDTO>> getAll(){
        return ApiResponse.<List<ClazzNotStudentResponseDTO>>builder()
                .message("Lấy danh sách lớp học thành công")
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

    @GetMapping("/subject/{id}")
    ApiResponse<List<ClazzNotStudentResponseDTO>> getAllClazzBySubjectId(@PathVariable Integer id){
        return ApiResponse.<List<ClazzNotStudentResponseDTO>>builder()
                .message("Lấy danh sách lớp theo môn học thành công")
                .data(clazzService.getAllClazzBySubjectId(id))
                .build();
    }

    @PostMapping("/{classID}/{studentID}")
    ApiResponse<?> delete(@PathVariable Integer classID, @PathVariable Integer studentID){
        clazzService.registryToClazz(classID, studentID);
        return ApiResponse.builder()
                .message("Đăng ký lớp học thành công")
                .build();
    }
}
