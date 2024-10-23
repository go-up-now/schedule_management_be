package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.response.RoomResponse;
import com.poly.schedule_manager_be.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
//    @Mapping(target = "requiredSubject", ignore = true)
//    @Mapping(target = "specialization", ignore = true)
//    Subject toSubject(SubjectRequest request);

    RoomResponse toRoomResponse(Room room);
//    void updateSubject(@MappingTarget Subject subject, SubjectRequest request);
}
