package com.poly.schedule_manager_be.service.impl;

import com.poly.schedule_manager_be.dto.request.SemesterProgressRequest;
import com.poly.schedule_manager_be.dto.response.SemesterProgressResponse;
import com.poly.schedule_manager_be.entity.SemesterProgress;
import com.poly.schedule_manager_be.exception.AppException;
import com.poly.schedule_manager_be.exception.ErrorCode;
import com.poly.schedule_manager_be.mapper.SemesterProgressMapper;
import com.poly.schedule_manager_be.repository.SemesterProgressRepository;
import com.poly.schedule_manager_be.service.SemesterProgressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SemesterProgressServiceImpl implements SemesterProgressService {

    SemesterProgressMapper semesterProgressMapper;
    SemesterProgressRepository semesterProgressRepository;

    @Override
    public SemesterProgressResponse create(SemesterProgressRequest request) {
        return null;
    }

    @Override
    public SemesterProgressResponse update(SemesterProgressRequest request, Integer id) {
        return null;
    }

    @Override
    public SemesterProgressResponse getOneByStatusTrue() {
        SemesterProgress semesterProgress = semesterProgressRepository.findByStatus(true).orElseThrow(()->
                new AppException(ErrorCode.SEMESTER_PROGRESS_NOT_OPEN));
        return semesterProgressMapper.toSemesterProgressResponse(semesterProgress);
    }
}
