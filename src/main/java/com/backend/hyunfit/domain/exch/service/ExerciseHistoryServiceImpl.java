package com.backend.hyunfit.domain.exch.service;

import com.backend.hyunfit.domain.exch.dto.ExerciseHistoryDTO;
import com.backend.hyunfit.domain.exch.mapper.ExerciseHistoryMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseHistoryServiceImpl implements ExerciseHistoryService{

    private final ExerciseHistoryMapper exerciseHistoryMapper;
    @Override
    public void createExerciseHistory(ExerciseHistoryDTO exerciseHistoryDTO) {
        int insertResult = exerciseHistoryMapper.insertOneExerciseHistory(exerciseHistoryDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }
}
