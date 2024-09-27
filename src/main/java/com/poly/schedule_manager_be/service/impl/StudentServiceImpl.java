package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.constant.RoleConstant;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.entity.Clazz;
import com.poly.schedule_manager_be.entity.Role;
import com.poly.schedule_manager_be.entity.Student;
import com.poly.schedule_manager_be.entity.User;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.StudentMapper;
import com.poly.schedule_manager_be.mapper.UserMapper;
import com.poly.schedule_manager_be.repository.ClazzRepository;
import com.poly.schedule_manager_be.repository.RoleRepository;
import com.poly.schedule_manager_be.repository.StudentRepository;
import com.poly.schedule_manager_be.repository.UserRepository;
import com.poly.schedule_manager_be.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class StudentServiceImpl implements StudentService {
    UserRepository userRepository;
    UserMapper userMapper;
    StudentMapper studentMapper;
    RoleRepository roleRepository;
    StudentRepository studentRepository;
    PasswordEncoder passwordEncoder;
    private final ClazzRepository clazzRepository;

    @Override
    public StudentResponseDTO create(StudentCreateRequestDTO requestDTO) {
        if (userRepository.existsByEmail(requestDTO.getUser().getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        Student student = studentMapper.toStudent(requestDTO);
        User user = student.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        HashSet<Role> roles = new HashSet<>();
        roleRepository.findByCode(RoleConstant.STUDENT_ROLE).ifPresent(roles::add);

        user.setRoles(roles);
        userRepository.save(user);

        student.setUser(user);

        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    public StudentResponseDTO update(StudentUpdateRequestDTO requestDTO, Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        User user = student.getUser();
        userMapper.updateUser(user, requestDTO.getUser());
        studentMapper.updateStudent(student, requestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        var roles = roleRepository.findAllById(request.getRoles());
//        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);
        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDTO getOne(Integer id) {
        return studentMapper.toStudentResponse(studentRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED)));
    }

    @Override
    public List<StudentResponseDTO> getAll() {
        return studentRepository.findAll().stream().map(studentMapper::toStudentResponse).toList();
    }

    @Override
    public StudentResponseDTO getMyInfor() {
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        Student student = studentRepository.findByUser(user).orElseThrow(()-> new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        return studentMapper.toStudentResponse(student);
    }

    @Override
    public void registerInClazz(Integer clazzId) {
        Clazz clazz = clazzRepository.findById(clazzId).orElseThrow(()->
                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        Student student = studentRepository.findByUser(user).orElseThrow(()-> new AppException(ErrorCode.NOT_STUDENT));

        List<Student> studentList = new ArrayList<>();

        clazz.getStudents().forEach(student1 -> {
            if(Objects.equals(student1.getId(), student.getId()))
                throw new AppException(ErrorCode.STUDENT_EXIST_IN_CLAZZ);
            studentList.add(student1);
            studentList.add(student);
        });

        clazz.setStudents(studentList);
        clazzRepository.save(clazz);
    }
}
