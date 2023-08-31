package com.backend.hyunfit.domain.exc.service;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.mapper.ExerciseMapper;
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