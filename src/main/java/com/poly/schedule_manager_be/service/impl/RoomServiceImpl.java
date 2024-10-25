package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.response.RoomResponse;
import com.poly.schedule_manager_be.dto.response.SpecializationResponse;
import com.poly.schedule_manager_be.mapper.RoomMapper;
import com.poly.schedule_manager_be.mapper.SpecializationMapper;
import com.poly.schedule_manager_be.repository.RoomRepository;
import com.poly.schedule_manager_be.repository.SpecializationRepository;
import com.poly.schedule_manager_be.service.RoomService;
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
public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;
    RoomMapper roomMapper;

    @Override
    public List<RoomResponse> getAll() {
        return roomRepository.findAll()
                .stream().map(roomMapper::toRoomResponse).toList();
    }

    @Override
    public List<RoomResponse> getAllByBuildingAreaId(Integer areaId) {
        return roomRepository.findAllByBuildingAreaId(areaId)
                .stream().map(roomMapper::toRoomResponse).toList();
    }

}
