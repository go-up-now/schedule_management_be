package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.response.ShiftResponse;
import com.poly.schedule_manager_be.mapper.ShiftMapper;
import com.poly.schedule_manager_be.repository.ShiftRepository;
import com.poly.schedule_manager_be.service.ShiftService;
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
public class ShiftServiceImpl implements ShiftService {
    ShiftRepository shiftRepository;
    ShiftMapper shiftMapper;

    @Override
    public List<ShiftResponse> getAll() {
        return shiftRepository.findAll()
                .stream().map(shiftMapper::toShiftResponse).toList();
    }

}
