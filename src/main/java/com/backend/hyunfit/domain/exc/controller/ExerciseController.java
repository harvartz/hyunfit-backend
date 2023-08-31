package com.backend.hyunfit.domain.exc.controller;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Excercise Controller" , description = "운동(동작)관련 컨트롤러")
public interface ExerciseController {

    @Operation(summary="Excercise의 접근권한 생성", description = "운동 정보 반환")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<ExerciseDTO> createExcercise(ExerciseDTO exerciseDTO);

    ResponseEntity<List<ExerciseDTO>> getAllExercises();
}
