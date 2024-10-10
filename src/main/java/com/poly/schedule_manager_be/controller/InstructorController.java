package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.InstructorResponse;
import com.poly.schedule_manager_be.service.InstructorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
////    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping
//    ApiResponse<List<StudentResponseDTO>> getAll(){
//        return ApiResponse.<List<StudentResponseDTO>>builder()
//                .message("Lấy danh sách sinh viên thành công")
//                .data(studentService.getAll())
//                .build();
//    }
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
