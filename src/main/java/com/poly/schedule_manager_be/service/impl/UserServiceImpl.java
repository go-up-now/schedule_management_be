package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.constant.RoleConstant;
import com.poly.schedule_manager_be.dto.request.UserCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.UserUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.UserResponseDTO;
import com.poly.schedule_manager_be.entity.Role;
import com.poly.schedule_manager_be.entity.User;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.UserMapper;
import com.poly.schedule_manager_be.repository.RoleRepository;
import com.poly.schedule_manager_be.repository.UserRepository;
import com.poly.schedule_manager_be.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO create(UserCreateRequestDTO requestDTO) {
        if (userRepository.existsByCode(requestDTO.getCode())) throw new AppException(ErrorCode.USER_CODE_EXISTED);
        if (userRepository.existsByEmail(requestDTO.getEmail())) throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(requestDTO);
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(RoleConstant.ADMIN_ROLE).ifPresent(roles::add);

        user.setRoles(roles);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDTO update(UserUpdateRequestDTO requestDTO, Integer id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(user, requestDTO);
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

//        var roles = roleRepository.findAllById(request.getRoles());
//        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO getOne(Integer id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponseDTO getMyInfor() {
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()->
                new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }
}
