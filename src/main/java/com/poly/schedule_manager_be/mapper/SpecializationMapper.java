package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.response.SpecializationResponse;
import com.poly.schedule_manager_be.entity.Specialization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {
//    @Mapping(target = "requiredSubject", ignore = true)
//    @Mapping(target = "specialization", ignore = true)
//    Subject toSubject(SubjectRequest request);

    SpecializationResponse toSpecializationResponse(Specialization specialization);
//    void updateSubject(@MappingTarget Subject subject, SubjectRequest request);
}
