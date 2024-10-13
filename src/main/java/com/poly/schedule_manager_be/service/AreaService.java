package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;

import java.util.List;

public interface AreaService {
    AreaResponse create(AreaRequest request);
    AreaResponse update(AreaRequest request, Integer id);
    void delete(Integer id);
    AreaResponse getOne(Integer id);
    List<AreaResponse> getAll();
}
