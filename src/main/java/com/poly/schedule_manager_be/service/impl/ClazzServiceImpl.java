package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.entity.*;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.ClazzMapper;
import com.poly.schedule_manager_be.repository.*;
import com.poly.schedule_manager_be.service.ClazzService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ClazzServiceImpl implements ClazzService {
    ClazzRepository clazzRepository;
    ClazzMapper clazzMapper;
    SubjectRepository subjectRepository;
    InstructorRepository instructorRepository;
    ShiftRepository shiftRepository;
    RoomRepository roomRepository;
    StudentRepository studentRepository;

    @Override
    public ClazzResponseDTO create(ClazzRequestDTO requestDTO) {
        if (clazzRepository.existsByCode(requestDTO.getCode()))
            throw new AppException(ErrorCode.CLAZZ_EXISTED);

        Clazz clazz = clazzMapper.toClazz(requestDTO);

        Subject subject = subjectRepository.findById(clazz.getSubject().getId()).orElseThrow(()->
                new AppException(ErrorCode.SUBJECT_NOT_EXISTED));
        Instructor instructor = instructorRepository.findById(clazz.getInstructor().getId()).orElseThrow(()->
                new AppException(ErrorCode.INSTRUCTOR_NOT_EXISTED));
        Shift shift = shiftRepository.findById(clazz.getShift().getId()).orElseThrow(()->
                new AppException(ErrorCode.SHIFT_NOT_EXISTED));
        Room room = roomRepository.findById(clazz.getRoom().getId()).orElseThrow(()->
                new AppException(ErrorCode.ROOM_NOT_EXISTED));

        clazz.setSubject(subject);
        clazz.setInstructor(instructor);
        clazz.setShift(shift);
        clazz.setRoom(room);
        clazz.setCreatedAt(LocalDateTime.now());

        return clazzMapper.toClazzResponse(clazzRepository.save(clazz));
    }

    @Override
    public ClazzResponseDTO update(ClazzRequestDTO requestDTO, Integer id) {
        Clazz clazz = clazzRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));

        clazzMapper.updateClazz(clazz, requestDTO);
        clazz.setUpdatedAt(LocalDateTime.now());

        return clazzMapper.toClazzResponse(clazzRepository.save(clazz));
    }

    @Override
    public void delete(Integer id) {
        clazzRepository.deleteById(id);
    }

    @Override
    public ClazzResponseDTO getOne(Integer id) {
        return clazzMapper.toClazzResponse(clazzRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.CLAZZ_NOT_EXISTED)));
    }

    @Override
    public List<ClazzResponseDTO> getAll() {
        return clazzRepository.findAll().stream().map(clazzMapper::toClazzNotStudentResponse).toList();
    }

    @Override
    public List<ClazzResponseDTO> getAllClazzBySubjectId(Integer subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->
                new AppException(ErrorCode.SUBJECT_NOT_EXISTED));

        return clazzRepository.findAllBySubject(subject).stream().map(clazzMapper::toClazzResponse).toList();
    }

    @Override
    public void registryToClazz(Integer classID, Integer studentID) {
        Clazz clazz = clazzRepository.findById(classID).orElseThrow(()->
                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));
        if(countByStudentsInClazz(clazz) >= 40)
            throw new AppException(ErrorCode.FULL_CLAZZ);

        Student student = studentRepository.findById(studentID).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));

        if(checkStudentHasClazz(student, clazz))
            throw new AppException(ErrorCode.CLAZZ_REGISTERED);

        clazz.getStudents().add(student);
//        student.getClazzes().add(clazz); // Thêm clazz vào danh sách lớp học của student

        clazzRepository.save(clazz); // Lưu lại lớp học
        studentRepository.save(student); // Lưu lại student nếu cần (chưa bắt buộc)
    }

    @Override
    public long countByStudentsInClazz(Clazz clazz) {
        System.out.println("count sv: "+ clazz.getStudents().size());
        return clazz.getStudents().size();
    }

    @Override
    public boolean checkStudentHasClazz(Student student, Clazz clazz) {
//        return student.getClazzes().stream()
//                .anyMatch(clazz1 -> clazz1.getId().equals(clazz.getId()));
        return true;
    }
}
