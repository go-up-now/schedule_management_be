package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.entity.Clazz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ClazzMapper {
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    @Mapping(target = "shift", ignore = true)
    @Mapping(target = "room", ignore = true)
    Clazz toClazz(ClazzRequestDTO request);

    @Mapping(target = "instructorCode", source = "instructor.user.code")
    ClazzResponseDTO toClazzResponse(Clazz clazz);

    @Mapping(target = "instructorCode", source = "instructor.user.code")
    @Mapping(target = "studyIns", ignore = true)
    ClazzResponseDTO toClazzNotStudentResponse(Clazz clazz);

    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    @Mapping(target = "shift", ignore = true)
    @Mapping(target = "room", ignore = true)
    @Mapping(target = "code", ignore = true)
    void updateClazz(@MappingTarget Clazz clazz, ClazzRequestDTO request);
}
