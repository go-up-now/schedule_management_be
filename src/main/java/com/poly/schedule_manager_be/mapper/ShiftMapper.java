package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.response.RoomResponse;
import com.poly.schedule_manager_be.dto.response.ShiftResponse;
import com.poly.schedule_manager_be.entity.Room;
import com.poly.schedule_manager_be.entity.Shift;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShiftMapper {
    ShiftResponse toShiftResponse(Shift shift);
}
