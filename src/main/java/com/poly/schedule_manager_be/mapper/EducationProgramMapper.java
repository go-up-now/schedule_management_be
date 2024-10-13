package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.request.Education_ProgramRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.dto.response.EducationProgramResponse;
import com.poly.schedule_manager_be.entity.Area;
import com.poly.schedule_manager_be.entity.Education_Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EducationProgramMapper {
    @Mapping(target = "major", ignore = true)
    Education_Program toEducation_Program(Education_ProgramRequest request);
    EducationProgramResponse toEducation_ProgramResponse(Education_Program area);

}
