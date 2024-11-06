package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    ClazzResponseDTO create(ClazzRequestDTO requestDTO);
    ClazzResponseDTO update(ClazzRequestDTO requestDTO, Integer id);
    void delete(Integer id);
    void importClazz(List<ClazzRequestDTO> listRequestDTO);
    ClazzResponseDTO getOne(Integer id);
    List<ClazzResponseDTO> getAll();
    List<ClazzResponseDTO> getAllClazzBySemesterAndYearAndSubject(Integer subjectId);
    ClazzResponseDTO getInforDetailBySubject(Integer subjectId);
    List<ClazzResponseDTO> findAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc();
}
