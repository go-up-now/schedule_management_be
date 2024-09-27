package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzNotStudentResponseDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClazzMapper {
    Clazz toClazz(ClazzRequestDTO request);

    @Mapping(target = "instructorID", source = "instructor.id")
    @Mapping(target = "subjectID", source = "subject.id")
    @Mapping(target = "shiftID", source = "shift.id")
    @Mapping(target = "roomID", source = "room.id")
    ClazzResponseDTO toClazzResponse(Clazz clazz);

    @Mapping(target = "instructorID", source = "instructor.id")
    @Mapping(target = "subjectID", source = "subject.id")
    @Mapping(target = "shiftID", source = "shift.id")
    @Mapping(target = "roomID", source = "room.id")
    ClazzNotStudentResponseDTO toClazzNotStudentResponse(Clazz clazz);
    void updateClazz(@MappingTarget Clazz clazz, ClazzRequestDTO request);
}
