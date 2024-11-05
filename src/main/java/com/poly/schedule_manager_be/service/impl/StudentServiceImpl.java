package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.constant.RoleConstant;
import com.poly.schedule_manager_be.dto.request.StudentCreateRequestDTO;
import com.poly.schedule_manager_be.dto.request.StudentUpdateRequestDTO;
import com.poly.schedule_manager_be.dto.response.StudentResponseDTO;
import com.poly.schedule_manager_be.entity.*;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.StudentMapper;
import com.poly.schedule_manager_be.mapper.UserMapper;
import com.poly.schedule_manager_be.repository.*;
import com.poly.schedule_manager_be.service.CloudinaryService;
import com.poly.schedule_manager_be.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
    ClazzRepository clazzRepository;
    AreaRepository areaRepository;
    EducationProgramRepository educationProgramRepository;
    CloudinaryService cloudinaryService;

    @Override
    public StudentResponseDTO create(StudentCreateRequestDTO requestDTO) {
        if (userRepository.existsByCode(requestDTO.getUser().getCode()))
            throw new AppException(ErrorCode.USER_CODE_EXISTED);
        if (userRepository.existsByEmail(requestDTO.getUser().getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        Student student = studentMapper.toStudent(requestDTO);
        User user = student.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Area area = areaRepository.findById(requestDTO.getUser().getArea()).orElseThrow(()->
                new AppException(ErrorCode.AREA_NOT_EXISTS));
        Education_Program educationProgram = educationProgramRepository
                .findById(requestDTO.getEducation_program()).orElseThrow(()->
                new AppException(ErrorCode.EDUCATION_PROGRAM_NOT_EXISTS));

        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(RoleConstant.STUDENT_ROLE).ifPresent(roles::add);

        user.setRoles(roles);
        user.setArea(area);
        userRepository.save(user);

        student.setEducation_program(educationProgram);
        student.setUser(user);

        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    public void importStudents(List<StudentCreateRequestDTO> listRequestDTO) {
        for (StudentCreateRequestDTO st : listRequestDTO) {
//            try {
                // Kiểm tra sự tồn tại của mã người dùng và email
                if (userRepository.existsByCode(st.getUser().getCode())) {
                    throw new AppException(ErrorCode.USER_CODE_EXISTED);
                }
                if (userRepository.existsByEmail(st.getUser().getEmail())) {
                    throw new AppException(ErrorCode.USER_EXISTED);
                }

                // Tạo và lưu đối tượng User
                User user = userMapper.toUser(st.getUser()); // Tạo User từ DTO
                user.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa mật khẩu

                // Kiểm tra Area
                Area area = areaRepository.findById(st.getUser().getArea())
                        .orElseThrow(() -> new AppException(ErrorCode.AREA_NOT_EXISTS));
                user.setArea(area); // Gán area cho User

                // Kiểm tra Roles
                HashSet<Role> roles = new HashSet<>();
                roleRepository.findById(RoleConstant.STUDENT_ROLE).ifPresent(roles::add);
                user.setRoles(roles); // Gán roles cho User

                // Lưu User và lấy lại đối tượng User đã lưu
                user = userRepository.save(user);

                // Tạo Student từ DTO
                Student student1 = studentMapper.toStudent(st);
                student1.setUser(user); // Gán User đã lưu cho Student

                // Kiểm tra Education Program
                Education_Program educationProgram = educationProgramRepository
                        .findByCode(st.getEducation_program())
                        .orElseThrow(() -> new AppException(ErrorCode.EDUCATION_PROGRAM_NOT_EXISTS));
                student1.setEducation_program(educationProgram); // Gán chương trình học cho Student

                // Lưu Student
                studentRepository.save(student1);

//            } catch (Exception e) {
//                // Ghi log thông tin lỗi để giúp bạn debug
//                System.err.println("Lỗi khi nhập sinh viên: " + e.getMessage());
//                throw new RuntimeException("Có lỗi xảy ra trong quá trình nhập sinh viên: " + e.getMessage());
//            }
        }
    }

    @Override
    public StudentResponseDTO update(StudentUpdateRequestDTO requestDTO, Integer id, MultipartFile avatar, String publicId) throws IOException{
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        Area area = areaRepository.findById(requestDTO.getUser().getArea()).orElseThrow(()->
                new AppException(ErrorCode.AREA_NOT_EXISTS));
        Education_Program educationProgram = educationProgramRepository
                .findById(requestDTO.getEducation_program()).orElseThrow(()->
                        new AppException(ErrorCode.EDUCATION_PROGRAM_NOT_EXISTS));

        User user = student.getUser();
        userMapper.updateUser(user, requestDTO.getUser());
        studentMapper.updateStudent(student, requestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setArea(area);

        student.setEducation_program(educationProgram);

        // Nếu có file hình ảnh mới, cập nhật hình ảnh trên Cloudinary và lưu URL
        if (avatar != null && !avatar.isEmpty()) {
            Path tempFile = Files.createTempFile(null, avatar.getOriginalFilename());
            Files.copy(avatar.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

            String imageUrl = cloudinaryService.uploadImage(tempFile.toFile(), publicId);

            // Cập nhật URL của hình ảnh trong User
            user.setAvatar(imageUrl);

            // Xóa file tạm
            Files.delete(tempFile);
        }

//        var roles = roleRepository.findAllById(request.getRoles());
//        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);
        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        String avatarUrl = student.getUser().getAvatar();

        try {
            studentRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            // Nếu có lỗi ràng buộc khóa ngoại, ném lỗi
            throw new AppException(ErrorCode.STUDENT_CANNOT_DELETE);
        }

        // Xóa hình ảnh từ Cloudinary
        if (avatarUrl != null && !avatarUrl.isEmpty()) {
            cloudinaryService.deleteImage(avatarUrl);
        }
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
    public StudentResponseDTO getStudentMyInfor() {
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        Student student = studentRepository.findByUser(user).orElseThrow(()-> new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        return studentMapper.toStudentResponse(student);
    }

    @Override
    public void registerInClazz(Integer clazzId) {
//        Clazz clazz = clazzRepository.findById(clazzId).orElseThrow(()->
//                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));
//        var context = SecurityContextHolder.getContext();
//        var email = context.getAuthentication().getName();
//        User user = userRepository.findByEmail(email).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
//        Student student = studentRepository.findByUser(user).orElseThrow(()-> new AppException(ErrorCode.NOT_STUDENT));
//
//        List<Student> studentList = new ArrayList<>();
//
//        clazz.getStudents().forEach(student1 -> {
//            if(Objects.equals(student1.getId(), student.getId()))
//                throw new AppException(ErrorCode.STUDENT_EXIST_IN_CLAZZ);
//            studentList.add(student1);
//            studentList.add(student);
//        });
//
//        clazz.setStudents(studentList);
//        clazzRepository.save(clazz);
    }

    @Override
    public void cancelRegisteredClazz(int clazzId) {
//        var context = SecurityContextHolder.getContext();
//        var email = context.getAuthentication().getName();
//        User user = userRepository.findByEmail(email).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
//        Student student = studentRepository.findByUser(user).orElseThrow(()-> new AppException(ErrorCode.STUDENT_NOT_EXISTED));
//
//        Clazz clazz = clazzRepository.findById(clazzId).orElseThrow(()->
//                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));
//
////        student.getClazzes().remove(clazz);
//        clazz.getStudents().remove(student);
//
//        studentRepository.save(student);
//        clazzRepository.save(clazz);
    }
}
