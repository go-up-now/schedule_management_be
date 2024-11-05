package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.SemesterProgressRequest;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;
import com.poly.schedule_manager_be.entity.SemesterProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemesterProgressMapper {
    SemesterProgress toSemesterProgress(SemesterProgressRequest request);
    SemesterProgressResponse toSemesterProgressResponse(SemesterProgress semesterProgress);

}
