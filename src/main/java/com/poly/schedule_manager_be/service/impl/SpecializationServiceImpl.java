package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.response.SpecializationResponse;
import com.poly.schedule_manager_be.dto.response.SubjectResponse;
import com.poly.schedule_manager_be.mapper.SpecializationMapper;
import com.poly.schedule_manager_be.mapper.SubjectMapper;
import com.poly.schedule_manager_be.repository.ClazzRepository;
import com.poly.schedule_manager_be.repository.SpecializationRepository;
import com.poly.schedule_manager_be.repository.StudentRepository;
import com.poly.schedule_manager_be.service.SpecializationService;
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
public class SpecializationServiceImpl implements SpecializationService {
    SpecializationRepository specializationRepository;
    SpecializationMapper specializationMapper;

    @Override
    public List<SpecializationResponse> getAll() {
        return specializationRepository.findAll()
                .stream().map(specializationMapper::toSpecializationResponse).toList();
    }

}
