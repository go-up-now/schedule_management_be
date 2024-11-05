package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.StudyInRequest;
import com.poly.schedule_manager_be.dto.response.StudyInResponse;
import com.poly.schedule_manager_be.entity.StudyIn;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudyInMapper {
    @Mapping(target = "clazz", ignore = true)
    @Mapping(target = "student", ignore = true)
    StudyIn toStudyIn(StudyInRequest request);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "clazz.subject.id")
    @Mapping(target = "clazzCode", source = "clazz.code")
    StudyInResponse toStudyInResponse(StudyIn studyIn);
}
