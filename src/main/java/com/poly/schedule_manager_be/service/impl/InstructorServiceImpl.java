package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.InstructorRequest;
import com.poly.schedule_manager_be.dto.request.RoleRequest;
import com.poly.schedule_manager_be.dto.response.InstructorResponse;
import com.poly.schedule_manager_be.dto.response.RoleResponse;
import com.poly.schedule_manager_be.entity.Instructor;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.User;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.InstructorMapper;
import com.poly.schedule_manager_be.mapper.RoleMapper;
import com.poly.schedule_manager_be.repository.InstructorRepository;
import com.poly.schedule_manager_be.repository.PermissionRepository;
import com.poly.schedule_manager_be.repository.RoleRepository;
import com.poly.schedule_manager_be.repository.UserRepository;
import com.poly.schedule_manager_be.service.InstructorService;
import com.poly.schedule_manager_be.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InstructorServiceImpl implements InstructorService {
    UserRepository userRepository;
    InstructorRepository instructorRepository;
    InstructorMapper instructorMapper;

    @Override
    public InstructorResponse create(InstructorRequest request) {
        return null;
    }

    @Override
    public InstructorResponse update(InstructorRequest request, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public InstructorResponse getOne(Integer id) {
        return null;
    }

    @Override
    public List<InstructorResponse> getAll() {
        return List.of();
    }

    @Override
    public InstructorResponse getInstructorMyInfor() {
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        Instructor instructor = instructorRepository.findByUser(user).orElseThrow(()-> new AppException(ErrorCode.INSTRUCTOR_NOT_EXISTED));

        return instructorMapper.toInstructorResponse(instructor);
    }
}
