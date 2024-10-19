package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.service.StudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentController {
    StudentService studentService;

    @PostMapping
    ApiResponse<StudentResponseDTO> create(@RequestBody @Valid StudentCreateRequestDTO requestDTO){
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Thêm sinh viên thành công")
                .data(studentService.create(requestDTO))
                .build();
    }

    @PostMapping("/import")
    ApiResponse<?> importExcel(@RequestBody @Valid List<StudentCreateRequestDTO> requestDTO){
        studentService.importStudents(requestDTO);
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Import excel sinh viên thành công")
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<StudentResponseDTO> update(@RequestBody @Valid StudentUpdateRequestDTO requestDTO,
                                        @PathVariable Integer id){
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Sửa sinh viên thành công")
                .data(studentService.update(requestDTO, id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<?> delete(@PathVariable Integer id){
        studentService.delete(id);
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Xóa sinh viên thành công")
                .build();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    ApiResponse<List<StudentResponseDTO>> getAll(){
        return ApiResponse.<List<StudentResponseDTO>>builder()
                .message("Lấy danh sách sinh viên thành công")
                .data(studentService.getAll())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<StudentResponseDTO> getOne(@PathVariable Integer id){
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Lấy sinh viên thành công")
                .data(studentService.getOne(id))
                .build();
    }

    @GetMapping("/myInfor")
    ApiResponse<StudentResponseDTO> getMyInfor(){
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Lấy thông tin cá nhân của sinh viên thành công")
                .data(studentService.getStudentMyInfor())
                .build();
    }

    @PostMapping("/registerInClazz/{clazzId}")
    ApiResponse<?> registerInClazz(@PathVariable Integer clazzId){
        studentService.registerInClazz(clazzId);
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Đăng ký lớp học thành công")
                .build();
    }

    @DeleteMapping("/cancel/{clazzId}")
    ApiResponse<?> cancelRegisteredClazz(@PathVariable Integer clazzId){
        studentService.cancelRegisteredClazz(clazzId);
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Hủy môn học thành công")
                .build();
    }
}
