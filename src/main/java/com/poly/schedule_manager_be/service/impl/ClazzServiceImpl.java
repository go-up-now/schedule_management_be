package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.ClazzRequestDTO;
import com.poly.schedule_manager_be.dto.response.ClazzResponseDTO;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;
import com.poly.schedule_manager_be.dto.response.StudyInResponse;
import com.poly.schedule_manager_be.entity.*;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.ClazzMapper;
import com.poly.schedule_manager_be.repository.*;
import com.poly.schedule_manager_be.service.AuthenticationService;
import com.poly.schedule_manager_be.service.ClazzService;
import com.poly.schedule_manager_be.service.SemesterProgressService;
import com.poly.schedule_manager_be.service.StudyInService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

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
    AuthenticationService authenticationService;
    SemesterProgressService semesterProgressService;
    StudyInService studyInService;

    @Override
    public ClazzResponseDTO create(ClazzRequestDTO requestDTO) {
        if (clazzRepository.existsByCode(requestDTO.getCode()))
            throw new AppException(ErrorCode.CLAZZ_EXISTED);

        Clazz clazz = clazzMapper.toClazz(requestDTO);

        Subject subject = subjectRepository.findByCode(requestDTO.getSubject()).orElseThrow(()->
                new AppException(ErrorCode.SUBJECT_NOT_EXISTED));
        Shift shift = shiftRepository.findById(requestDTO.getShift()).orElseThrow(()->
                new AppException(ErrorCode.SHIFT_NOT_EXISTED));

        if(requestDTO.getRoom() != null){
            Room room = roomRepository.findByRoom(requestDTO.getRoom()).orElseThrow(()->
                    new AppException(ErrorCode.ROOM_NOT_EXISTED));
            clazz.setRoom(room);
        }

        if(requestDTO.getInstructorCode() != null && !requestDTO.getInstructorCode().isEmpty()){
            Instructor instructor = instructorRepository.findByUserCode(requestDTO.getInstructorCode()).orElseThrow(()->
                    new AppException(ErrorCode.INSTRUCTOR_NOT_EXISTED));
            clazz.setInstructor(instructor);
        }

        clazz.setSubject(subject);
        clazz.setShift(shift);
        clazz.setCreatedAt(LocalDateTime.now());

        return clazzMapper.toClazzNotStudentResponse(clazzRepository.save(clazz));
    }

    @Override
    public ClazzResponseDTO update(ClazzRequestDTO requestDTO, Integer id) {
        Clazz clazz = clazzRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.CLAZZ_NOT_EXISTED));

        clazzMapper.updateClazz(clazz, requestDTO);
        clazz.setUpdatedAt(LocalDateTime.now());

        Subject subject = subjectRepository.findByCode(requestDTO.getSubject()).orElseThrow(()->
                new AppException(ErrorCode.SUBJECT_NOT_EXISTED));
        Shift shift = shiftRepository.findById(requestDTO.getShift()).orElseThrow(()->
                new AppException(ErrorCode.SHIFT_NOT_EXISTED));

        if(requestDTO.getRoom() != null){
            Room room = roomRepository.findByRoom(requestDTO.getRoom()).orElseThrow(()->
                    new AppException(ErrorCode.ROOM_NOT_EXISTED));
            clazz.setRoom(room);
        }

        if(requestDTO.getInstructorCode() != null && !requestDTO.getInstructorCode().isEmpty()){
            Instructor instructor = instructorRepository.findByUserCode(requestDTO.getInstructorCode()).orElseThrow(()->
                    new AppException(ErrorCode.INSTRUCTOR_NOT_EXISTED));
            clazz.setInstructor(instructor);
        }

        clazz.setSubject(subject);
        clazz.setShift(shift);

        return clazzMapper.toClazzNotStudentResponse(clazzRepository.save(clazz));
    }

    @Override
    public void delete(Integer id) {
        try {
            clazzRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            // Nếu có lỗi ràng buộc khóa ngoại, ném lỗi
            throw new AppException(ErrorCode.CLAZZ_CANNOT_DELETE);
        }
    }

    @Override
    public void importClazz(List<ClazzRequestDTO> listRequestDTO) {
        for (ClazzRequestDTO clazzReq : listRequestDTO) {

            // Kiểm tra sự tồn tại của mã clazz
            if (clazzRepository.existsByCode(clazzReq.getCode())) {
                throw new AppException(ErrorCode.CLAZZ_EXISTED);
            }

            // Tạo và lưu đối tượng CLAZZ
            Clazz clazz = clazzMapper.toClazz(clazzReq);

            // Kiểm tra instructor
            if(clazzReq.getInstructorCode() != null && !clazzReq.getInstructorCode().isEmpty()){
                Instructor instructor = instructorRepository.findByUserCode(clazzReq.getInstructorCode()).orElseThrow(()->
                        new AppException(ErrorCode.INSTRUCTOR_NOT_EXISTED));
                clazz.setInstructor(instructor);
            }

            // Kiểm tra room
            if(clazzReq.getRoom() != null){
                Room room = roomRepository.findByRoom(clazzReq.getRoom()).orElseThrow(()->
                        new AppException(ErrorCode.ROOM_NOT_EXISTED));
                clazz.setRoom(room);
            }

            Subject subject = subjectRepository.findByCode(clazzReq.getSubject()).orElseThrow(()->
                    new AppException(ErrorCode.SUBJECT_NOT_EXISTED));
            Shift shift = shiftRepository.findById(clazzReq.getShift()).orElseThrow(()->
                    new AppException(ErrorCode.SHIFT_NOT_EXISTED));

            clazz.setSubject(subject);
            clazz.setShift(shift);

            // Lưu clazz
            clazzRepository.save(clazz);
        }
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
    public List<ClazzResponseDTO> getAllClazzBySemesterAndYearAndSubject(Integer subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->
                new AppException(ErrorCode.SUBJECT_NOT_EXISTED));

        SemesterProgressResponse semesterProgress = semesterProgressService.getOneByStatusTrue();

        return clazzRepository.findAllBySemesterAndYearAndSubject(semesterProgress.getSubjectSemesterOpen(),
                        semesterProgress.getSubjectYearOpen(), subject)
                .stream().map(clazzMapper::toClazzResponse).toList();
    }

    @Override
    public ClazzResponseDTO getInforDetailBySubject(Integer subjectId) {
        AtomicReference<StudyInResponse> studyInResponse = new AtomicReference<>(new StudyInResponse());
        studyInService.getAllBySemetserAndYear().forEach(studyIn -> {
            if(Objects.equals(studyIn.getSubjectId(), subjectId))
                studyInResponse.set(studyIn);
        });
        return clazzMapper.toClazzResponse(clazzRepository.findByCode(studyInResponse.get().getClazzCode())
                .orElseThrow(() -> new AppException(ErrorCode.CLAZZ_NOT_EXISTED)));
    }

    @Override
    public List<ClazzResponseDTO> findAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc() {
        User user = authenticationService.getInforAuthenticated();
        Student student = studentRepository.findByUser(user).orElseThrow(()->
                new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        LocalDate startDate = LocalDate.now().minusDays(30);
        LocalDate endDate = LocalDate.now().plusDays(30);

        return clazzRepository.findAllByStudyInsStudentAndStartTimeBetweenOrEndTimeBetweenOrderByStartTimeAsc(
                student, startDate, endDate, startDate, endDate
        ).stream().map(clazzMapper::toClazzNotStudentResponse).toList();
    }
}
