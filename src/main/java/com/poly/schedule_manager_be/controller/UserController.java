package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import com.poly.schedule_manager_be.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserResponseDTO> create(@RequestBody @Valid UserCreateRequestDTO requestDTO){
        return ApiResponse.<UserResponseDTO>builder()
                .message("Thêm người dùng thành công")
                .data(userService.create(requestDTO))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<UserResponseDTO> update(@RequestBody @Valid UserUpdateRequestDTO requestDTO,
                                        @PathVariable Integer id){
        return ApiResponse.<UserResponseDTO>builder()
                .message("Sửa người dùng thành công")
                .data(userService.update(requestDTO, id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return ApiResponse.<UserResponseDTO>builder()
                .message("Xóa người dùng thành công")
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponseDTO>> getAll(){
        return ApiResponse.<List<UserResponseDTO>>builder()
                .message("Lấy danh sách người dùng thành công")
                .data(userService.getAll())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<UserResponseDTO> getOne(@PathVariable Integer id){
        return ApiResponse.<UserResponseDTO>builder()
                .message("Lấy người dùng thành công")
                .data(userService.getOne(id))
                .build();
    }
}