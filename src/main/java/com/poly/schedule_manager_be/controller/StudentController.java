package com.poly.schedule_manager_be.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.service.CloudinaryService;
import com.poly.schedule_manager_be.service.StudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentController {
    StudentService studentService;
    CloudinaryService cloudinaryService;
    ObjectMapper objectMapper;

//    @PostMapping
//    ApiResponse<StudentResponseDTO> create(@RequestBody @Valid StudentCreateRequestDTO requestDTO){
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Thêm sinh viên thành công")
//                .data(studentService.create(requestDTO))
//                .build();
//    }

    @PostMapping
    ApiResponse<StudentResponseDTO> create(@RequestParam(value = "avatar", required = false) MultipartFile avatar,
                                           @RequestParam("student") @Valid String studentJson) throws IOException {
        String imageUrl = "";
        // Xử lý file ảnh nếu có
        if (avatar != null && !avatar.isEmpty()) {
            Map<String, Object> uploadResult = cloudinaryService.uploadFile(avatar);
            // URL của hình ảnh đã upload
            imageUrl = (String) uploadResult.get("url");
        }

        // Chuyển chuỗi JSON của student thành object Java
        try {
            StudentCreateRequestDTO request = objectMapper.readValue(studentJson, StudentCreateRequestDTO.class); // Parse JSON thành object Student
               request.getUser().setAvatar(imageUrl);
            return ApiResponse.<StudentResponseDTO>builder()
                    .message("Thêm sinh viên thành công")
                    .data(studentService.create(request))
                    .build();
        } catch (JsonProcessingException e) {
            return ApiResponse.<StudentResponseDTO>builder()
                    .message("Dữ liệu sinh viên không hợp lệ")
                    .build();
        }
    }

    @PostMapping("/import")
    ApiResponse<?> importExcel(@RequestBody @Valid List<StudentCreateRequestDTO> requestDTO){
        studentService.importStudents(requestDTO);
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Import excel sinh viên thành công")
                .build();
    }

//    @PutMapping("/{id}")
//    ApiResponse<StudentResponseDTO> update(@RequestBody @Valid StudentUpdateRequestDTO requestDTO,
//                                        @PathVariable Integer id){
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Sửa sinh viên thành công")
//                .data(studentService.update(requestDTO, id))
//                .build();
//    }

    @PutMapping("/{id}")
    ApiResponse<StudentResponseDTO> update(@RequestParam(value = "avatar", required = false) MultipartFile avatar,
                                           @RequestParam("student") @Valid String studentJson,
                                           @RequestParam("publicId") String publicId,
                                           @PathVariable Integer id){
        // Chuyển chuỗi JSON của student thành object Java
        try {
            StudentUpdateRequestDTO request = objectMapper.readValue(studentJson, StudentUpdateRequestDTO.class); // Parse JSON thành object Student
            return ApiResponse.<StudentResponseDTO>builder()
                    .message("Sửa sinh viên thành công")
                    .data(studentService.update(request, id, avatar, publicId))
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return ApiResponse.<StudentResponseDTO>builder()
                    .message("Dữ liệu sinh viên không hợp lệ")
                    .build();
        }
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

//    @PostMapping("/registerInClazz/{clazzId}")
//    ApiResponse<?> registerInClazz(@PathVariable Integer clazzId){
//        studentService.registerInClazz(clazzId);
//        return ApiResponse.<StudentResponseDTO>builder()
//                .message("Đăng ký lớp học thành công")
//                .build();
//    }

    @DeleteMapping("/cancel/{clazzId}")
    ApiResponse<?> cancelRegisteredClazz(@PathVariable Integer clazzId){
        studentService.cancelRegisteredClazz(clazzId);
        return ApiResponse.<StudentResponseDTO>builder()
                .message("Hủy môn học thành công")
                .build();
    }
}
