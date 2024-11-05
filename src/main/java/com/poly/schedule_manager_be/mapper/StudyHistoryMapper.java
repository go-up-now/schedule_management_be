package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.response.StudyHistoryResponse;
import com.poly.schedule_manager_be.entity.Study_History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudyHistoryMapper {
//    Area toArea(AreaRequest request);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    StudyHistoryResponse toStudyHistoryResponseResponse(Study_History studyHistory);

}
