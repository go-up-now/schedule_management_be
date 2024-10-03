package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzNotStudentResponseDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import com.poly.schedule_manager_be.entity.Clazz;

import java.util.List;

public interface ClazzService {
    ClazzResponseDTO create(ClazzRequestDTO requestDTO);
    ClazzResponseDTO update(ClazzRequestDTO requestDTO, Integer id);
    void delete(Integer id);
    ClazzResponseDTO getOne(Integer id);
    List<ClazzNotStudentResponseDTO> getAll();
    List<ClazzNotStudentResponseDTO> getAllClazzBySubjectId(Integer subjectId);
    void registryToClazz(Integer classID, Integer studentID);
    long countByStudentsInClazz(Clazz clazz);
}
