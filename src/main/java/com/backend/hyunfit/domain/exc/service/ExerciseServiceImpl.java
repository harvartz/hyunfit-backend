package com.backend.hyunfit.domain.exc.service;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.dto.ExerciseInTargetDTO;
import com.backend.hyunfit.domain.exc.mapper.ExerciseMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseMapper exerciseMapper;


    @Transactional
    @Override
    public ExerciseDTO insertExerciseAndTarget(ExerciseDTO exerciseDTO) {
        exerciseMapper.insertOneExercise(exerciseDTO);
        Long generatedExcSeq = exerciseDTO.getExcSeq();
        for (ExerciseInTargetDTO target : exerciseDTO.getExerciseTargets()) {
            target.setExcSeq(generatedExcSeq);
            exerciseMapper.insertExerciseTarget(target);
        }
        return exerciseDTO;
    }

    @Override
    public List<ExerciseDTO> getAllExercises() {
        return exerciseMapper.selectAllExercises();
    }

    @Transactional
    @Override
    public int removeExercise(Long excSeq) {
        int affectedRows = exerciseMapper.deleteExercise(excSeq);
        if (affectedRows == 0) {
            throw BusinessException.of(ErrorCode.URL_NOT_FOUND);
        }
        return affectedRows;
    }

    @Override
    public ExerciseDTO selectOneExercise(Long excSeq) {
        return exerciseMapper.selectOneExercise(excSeq)
                .orElseThrow(BusinessException.supplierOf(ErrorCode.USERID_NOT_FOUND));
    }
}
