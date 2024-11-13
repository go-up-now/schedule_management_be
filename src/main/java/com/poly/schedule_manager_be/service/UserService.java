package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    UserResponseDTO create(UserCreateRequestDTO requestDTO);
    UserResponseDTO update(UserUpdateRequestDTO requestDTO, Integer id);
    void delete(Integer id);
    UserResponseDTO getOne(Integer id);
    List<UserResponseDTO> getAll();
    UserResponseDTO getMyInfor();
    void updateImage(Integer id, MultipartFile avatar, String publicId);
}
