package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.InstructorResponse;
import com.poly.schedule_manager_be.service.InstructorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InstructorController {
    InstructorService instructorService;

//    @PostMapping
//    ApiResponse<StudentResponseDTO> create(@RequestBody @Valid StudentCreateRequestDTO requestDTO){
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Thêm sinh viên thành công")
//                .data(studentService.create(requestDTO))
//                .build();
//    }
//
//    @PutMapping("/{id}")
//    ApiResponse<StudentResponseDTO> update(@RequestBody @Valid StudentUpdateRequestDTO requestDTO,
//                                        @PathVariable Integer id){
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Sửa sinh viên thành công")
//                .data(studentService.update(requestDTO, id))
//                .build();
//    }
//
//    @DeleteMapping("/{id}")
//    ApiResponse<?> delete(@PathVariable Integer id){
//        studentService.delete(id);
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Xóa sinh viên thành công")
//                .build();
//    }
//
    @GetMapping
    ApiResponse<List<InstructorResponse>> getAll(){
        return ApiResponse.<List<InstructorResponse>>builder()
                .message("Lấy danh sách giảng viên thành công")
                .data(instructorService.getAll())
                .build();
    }

    @GetMapping("/{areaId}")
    ApiResponse<List<InstructorResponse>> getAll(@PathVariable Integer areaId){
        return ApiResponse.<List<InstructorResponse>>builder()
                .message("Lấy danh sách giảng viên theo khu vực thành công")
                .data(instructorService.getAllByUserAreaId(areaId))
                .build();
    }
//
//    @GetMapping("/{id}")
//    ApiResponse<StudentResponseDTO> getOne(@PathVariable Integer id){
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Lấy sinh viên thành công")
//                .data(studentService.getOne(id))
//                .build();
//    }

    @GetMapping("/myInfor")
    ApiResponse<InstructorResponse> getMyInfor(){
        return ApiResponse.<InstructorResponse>builder()
                .message("Lấy thông tin cá nhân của giảng viên thành công")
                .data(instructorService.getInstructorMyInfor())
                .build();
    }

}
