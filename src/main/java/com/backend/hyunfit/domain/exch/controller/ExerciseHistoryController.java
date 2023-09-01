package com.backend.hyunfit.domain.exch.controller;

import com.backend.hyunfit.domain.exch.dto.ExerciseHistoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "ExerciseHistory Controller" , description = "운동기록 관련 컨트롤러")
public interface ExerciseHistoryController {
    @Operation(summary="ExerciseHistory 생성", description = "운동 기록 생성")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<ExerciseHistoryDTO> createExerciseHistory(ExerciseHistoryDTO exerciseHistoryDTO);
}
