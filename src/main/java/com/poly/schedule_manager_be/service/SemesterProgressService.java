package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.SemesterProgressRequest;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;

public interface SemesterProgressService {
    SemesterProgressResponse create(SemesterProgressRequest request);
    SemesterProgressResponse update(SemesterProgressRequest request, Integer id);
    SemesterProgressResponse getOneByStatusTrue();
}
