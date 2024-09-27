package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentCreateRequestDTO request);
    StudentResponseDTO toStudentResponse(Student student);

    @Mapping(target = "user.roles", ignore = true)
    void updateStudent(@MappingTarget Student student, StudentUpdateRequestDTO request);
}
