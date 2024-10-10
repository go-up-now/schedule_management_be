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
    @Mapping(target = "education_program", ignore = true)
    Student toStudent(StudentCreateRequestDTO request);
    @Mapping(target = "education_program", source = "education_program.code")
    StudentResponseDTO toStudentResponse(Student student);

    @Mapping(target = "user.roles", ignore = true)
    @Mapping(target = "education_program", ignore = true)
    void updateStudent(@MappingTarget Student student, StudentUpdateRequestDTO request);
}
