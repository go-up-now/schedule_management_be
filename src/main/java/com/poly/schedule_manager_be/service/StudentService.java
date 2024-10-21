package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    StudentResponseDTO create(StudentCreateRequestDTO requestDTO);
    void importStudents(List<StudentCreateRequestDTO> listRequestDTO);
    StudentResponseDTO update(StudentUpdateRequestDTO requestDTO, Integer id, MultipartFile avatar, String publicId) throws IOException;
    void delete(Integer id);
    StudentResponseDTO getOne(Integer id);
    List<StudentResponseDTO> getAll();
    StudentResponseDTO getStudentMyInfor();
    void registerInClazz(Integer clazzId);
    void cancelRegisteredClazz(int clazzId);
}
