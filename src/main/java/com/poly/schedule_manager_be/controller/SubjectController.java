package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
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

//    @PostMapping
//    ApiResponse<UserResponseDTO> create(@RequestBody @Valid UserCreateRequestDTO requestDTO){
//        return ApiResponse.<UserResponseDTO>builder()
//                .message("Thêm người dùng thành công")
//                .data(userService.create(requestDTO))
//                .build();
//    }
//
//    @PutMapping("/{id}")
//    ApiResponse<UserResponseDTO> update(@RequestBody @Valid UserUpdateRequestDTO requestDTO,
//                                        @PathVariable Integer id){
//        return ApiResponse.<UserResponseDTO>builder()
//                .message("Sửa người dùng thành công")
//                .data(userService.update(requestDTO, id))
//                .build();
//    }
//
//    @DeleteMapping("/{id}")
//    ApiResponse<?> delete(@PathVariable Integer id){
//        userService.delete(id);
//        return ApiResponse.<UserResponseDTO>builder()
//                .message("Xóa người dùng thành công")
//                .build();
//    }

    @GetMapping
    ApiResponse<List<SubjectResponse>> getAll(){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học thành công")
                .data(subjectService.getAll())
                .build();
    }

    @GetMapping("/{semester}/{year}")
    ApiResponse<List<SubjectResponse>> getAllSubjectBySemesterAndYear(
            @PathVariable String semester, @PathVariable int year){
        return ApiResponse.<List<SubjectResponse>>builder()
                .message("Lấy danh sách môn học theo năm và học kỳ thành công")
                .data(subjectService.findSubjectBySemesterAndYear(semester, year))
                .build();
    }

//    @GetMapping("/{id}")
//    ApiResponse<UserResponseDTO> getOne(@PathVariable Integer id){
//        return ApiResponse.<UserResponseDTO>builder()
//                .message("Lấy người dùng thành công")
//                .data(userService.getOne(id))
//                .build();
//    }
}
