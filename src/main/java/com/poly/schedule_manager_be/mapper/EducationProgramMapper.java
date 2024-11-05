package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.Education_ProgramRequest;
import com.poly.schedule_manager_be.dto.response.Education_ProgramResponse;
import com.poly.schedule_manager_be.entity.Education_Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EducationProgramMapper {
    @Mapping(target = "major", ignore = true)
    Education_Program toEducation_Program(Education_ProgramRequest request);
    Education_ProgramResponse toEducation_ProgramResponse(Education_Program area);

}
