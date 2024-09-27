package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO create(StudentCreateRequestDTO requestDTO);
    StudentResponseDTO update(StudentUpdateRequestDTO requestDTO, Integer id);
    void delete(Integer id);
    StudentResponseDTO getOne(Integer id);
    List<StudentResponseDTO> getAll();
    StudentResponseDTO getMyInfor();
    void registerInClazz(Integer clazzId);
}
