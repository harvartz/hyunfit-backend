package com.backend.hyunfit.domain.exch.controller;

import com.backend.hyunfit.domain.exch.dto.ExerciseHistoryDTO;
import com.backend.hyunfit.domain.exch.service.ExerciseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/exercise-history")
@RestController
@RequiredArgsConstructor
public class ExerciseHistoryControllerImpl implements ExerciseHistoryController{

    private final ExerciseHistoryService exerciseHistoryService;
    @Override
    @PostMapping
    public ResponseEntity<ExerciseHistoryDTO> createExerciseHistory(@RequestBody ExerciseHistoryDTO exerciseHistoryDTO){
        exerciseHistoryService.createExerciseHistory(exerciseHistoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseHistoryDTO);
    }
}
