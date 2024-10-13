package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.request.MajorRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.dto.response.MajorResponse;
import com.poly.schedule_manager_be.mapper.AreaMapper;
import com.poly.schedule_manager_be.mapper.MajorMapper;
import com.poly.schedule_manager_be.repository.AreaRepository;
import com.poly.schedule_manager_be.repository.MajorRepository;
import com.poly.schedule_manager_be.service.AreaService;
import com.poly.schedule_manager_be.service.MajorService;
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
public class MojorServiceImpl implements MajorService {

    MajorRepository majorRepository;
    MajorMapper majorMapper;

    @Override
    public MajorResponse create(MajorRequest request) {
        return null;
    }

    @Override
    public MajorResponse update(MajorRequest request, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public MajorResponse getOne(Integer id) {
        return null;
    }

    @Override
    public List<MajorResponse> getAll() {
        return majorRepository.findAll().stream().map(majorMapper::toMajorResponse).toList();

    }
}
