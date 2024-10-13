package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.MajorRequest;
import com.poly.schedule_manager_be.dto.response.MajorResponse;

import java.util.List;

public interface MajorService {
    MajorResponse create(MajorRequest request);
    MajorResponse update(MajorRequest request, Integer id);
    void delete(Integer id);
    MajorResponse getOne(Integer id);
    List<MajorResponse> getAll();
}
