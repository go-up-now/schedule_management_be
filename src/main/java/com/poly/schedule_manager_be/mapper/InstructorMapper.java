package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.InstructorRequest;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.InstructorResponse;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.entity.Instructor;
import com.poly.schedule_manager_be.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    @Mapping(target = "specialization", ignore = true)
    Instructor toInstructor(InstructorRequest request);

    InstructorResponse toInstructorResponse(Instructor instructor);

    @Mapping(target = "specialization", ignore = true)
    void updateInstructor(@MappingTarget Instructor instructor, InstructorRequest request);
}
