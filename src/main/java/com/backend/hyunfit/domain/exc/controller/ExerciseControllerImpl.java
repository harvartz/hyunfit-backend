package com.backend.hyunfit.domain.exercise.controller;

import com.backend.hyunfit.domain.exercise.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exercise.service.ExerciseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/exercises")
@RestController
@RequiredArgsConstructor
public class ExerciseControllerImpl implements ExerciseController {

    private final ExerciseServiceImpl exerciseService;

    @Override
    @PostMapping
    public ResponseEntity<ExerciseDTO> createExcercise(ExerciseDTO exerciseDTO) {
        exerciseService.createExercise(exerciseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created 응답 반환
    }

    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> getAllExercises() {
        List<ExerciseDTO> exercises = exerciseService.getAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
