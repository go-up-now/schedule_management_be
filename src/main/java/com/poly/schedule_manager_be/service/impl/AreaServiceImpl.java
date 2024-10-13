package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.mapper.AreaMapper;
import com.poly.schedule_manager_be.repository.AreaRepository;
import com.poly.schedule_manager_be.service.AreaService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AreaServiceImpl implements AreaService {

    AreaRepository areaRepository;
    AreaMapper areaMapper;

    @Override
    public AreaResponse create(AreaRequest request) {
        return null;
    }

    @Override
    public AreaResponse update(AreaRequest request, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public AreaResponse getOne(Integer id) {
        return null;
    }

    @Override
    public List<AreaResponse> getAll() {
        return areaRepository.findAll().stream().map(areaMapper::toAreaResponse).toList();

    }
}
