package com.backend.hyunfit.domain.exc.service;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;

import java.util.List;


public interface ExerciseService {

    int createExercise(ExerciseDTO exerciseDTO);

    List<ExerciseDTO> getAllExercises();

    int removeExercise(Long excSeq);

    ExerciseDTO selectOneExercise(Long excSeq);
}
