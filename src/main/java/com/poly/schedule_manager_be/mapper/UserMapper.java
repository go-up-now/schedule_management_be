package com.poly.schedule_manager_be.mapper;

import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import com.poly.schedule_manager_be.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "area", ignore = true)
    User toUser(UserCreateRequestDTO request);

//    @Mapping(target = "area", source = "area.id")
    UserResponseDTO toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "area", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequestDTO request);
}
