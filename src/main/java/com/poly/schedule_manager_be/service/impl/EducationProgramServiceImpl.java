package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.AreaRequest;
import com.poly.schedule_manager_be.dto.request.Education_ProgramRequest;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.dto.response.EducationProgramResponse;
import com.poly.schedule_manager_be.mapper.AreaMapper;
import com.poly.schedule_manager_be.mapper.EducationProgramMapper;
import com.poly.schedule_manager_be.repository.AreaRepository;
import com.poly.schedule_manager_be.repository.EducationProgramRepository;
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
public class EducationProgramServiceImpl implements EducationProgramService {

    EducationProgramRepository educationProgramRepository;
    EducationProgramMapper educationProgramMapper;

    @Override
    public EducationProgramResponse create(Education_ProgramRequest request) {
        return null;
    }

    @Override
    public EducationProgramResponse update(Education_ProgramRequest request, String code) {
        return null;
    }

    @Override
    public void delete(String code) {

    }

    @Override
    public EducationProgramResponse getOne(String code) {
        return null;
    }

    @Override
    public List<EducationProgramResponse> getAll() {
        return educationProgramRepository.findAll()
                .stream().map(educationProgramMapper::toEducation_ProgramResponse).toList();

    }
}
