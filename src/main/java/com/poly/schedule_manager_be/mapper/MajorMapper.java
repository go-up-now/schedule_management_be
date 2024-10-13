package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.MajorRequest;
import com.poly.schedule_manager_be.dto.response.MajorResponse;
import com.poly.schedule_manager_be.entity.Major;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MajorMapper {
    Major toMajor(MajorRequest request);
    MajorResponse toMajorResponse(Major major);

}
