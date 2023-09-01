package com.backend.hyunfit.domain.exc.controller;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Exercise Controller" , description = "운동(동작)관련 컨트롤러")
public interface ExerciseController {

    @Operation(summary="Exercise 생성", description = "운동 정보 생성")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<ExerciseDTO> createExercise(ExerciseDTO exerciseDTO);
    
    @Operation(summary="Exercise 전체 목록 불러오기", description = "전체 운동 정보 조회")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<List<ExerciseDTO>> getAllExercises();

    @Operation(summary="Exercise 한가지 운동 목록 불러오기", description = "시퀀스로 해당하는 하나의 운동 정보 조회")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<ExerciseDTO> getOneExercises(@PathVariable Long excSeq);
    
    @Operation(summary="특정 Exercise 삭제", description = "입력한 exc_seq 운동 정보 삭제")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<Void> removeExercise(@PathVariable Long excSeq);
}
