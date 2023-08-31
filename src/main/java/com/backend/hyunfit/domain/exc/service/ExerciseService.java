package com.backend.hyunfit.domain.exercise.service;

import com.backend.hyunfit.domain.exercise.dto.ExerciseDTO;

import java.util.List;


public interface ExerciseService {

    int createExercise(ExerciseDTO exerciseDTO);

    List<ExerciseDTO> getAllExercises();

}
