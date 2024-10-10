package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.entity.Clazz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClazzMapper {
    Clazz toClazz(ClazzRequestDTO request);

    @Mapping(target = "instructorID", source = "instructor.id")
    @Mapping(target = "subjectID", source = "subject.id")
    @Mapping(target = "shiftID", source = "shift.id")
    @Mapping(target = "room", source = "room.room")
    ClazzResponseDTO toClazzResponse(Clazz clazz);

    @Mapping(target = "instructorID", source = "instructor.id")
    @Mapping(target = "subjectID", source = "subject.id")
    @Mapping(target = "shiftID", source = "shift.id")
    @Mapping(target = "room", source = "room.room")
    @Mapping(target = "students", ignore = true)
    ClazzResponseDTO toClazzNotStudentResponse(Clazz clazz);
    void updateClazz(@MappingTarget Clazz clazz, ClazzRequestDTO request);
}
