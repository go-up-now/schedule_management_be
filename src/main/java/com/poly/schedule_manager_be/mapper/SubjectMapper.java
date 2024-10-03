package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.SubjectRequest;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toSubject(SubjectRequest request);

    @Mapping(target = "requiredSubjectID", source = "requiredSubject.id")
    SubjectResponse toSubjectResponse(Subject subject);

    @Mapping(target = "specializations", ignore = true)
    void updateSubject(@MappingTarget Subject subject, SubjectRequest request);
}
