package com.backend.hyunfit.domain.exercise.service;

import com.backend.hyunfit.domain.exercise.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exercise.mapper.ExerciseMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseMapper exerciseMapper;

    @Override
    public int createExercise(ExerciseDTO exerciseDTO) {
        return exerciseMapper.insertOneExercise(exerciseDTO);
    }


    @Override
    public List<ExerciseDTO> getAllExercises() {
        return exerciseMapper.selectAllExercises();
    }
}