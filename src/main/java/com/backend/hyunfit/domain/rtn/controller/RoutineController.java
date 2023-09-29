package com.backend.hyunfit.domain.rtn.controller;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import com.backend.hyunfit.domain.rtn.dto.RoutineSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Routine Controller", description = "Routine 관련 컨트롤러")
public interface RoutineController {
    @Operation(summary = "Routine 전체 검색 API입니다", description = "RoutineDTO routineDTO 모든 루틴을 반환합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST, 올바른 검색 조건이 아님")
    @ApiResponse(responseCode = "404", description = "NOT FOUND, 검색 조건에 맞는 루틴이 없음")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<List<RoutineDTO>> selectAllRoutineSearch(RoutineSearchDTO routineDTO);

    @Operation(summary = "단일 Routine 추가 API입니다", description = "새로운 루틴을 추가합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<RoutineDTO> createOneRoutine(@RequestBody RoutineDTO routineDTO);

    @Operation(summary = "단일 Routine 조회 API입니다", description = "루틴 정보, 매핑되어있는 운동(ExerciseDTO) 리스트 데이터를 담고있는 RoutineDTO를 반환합니다")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<RoutineDTO> getOneRoutineByRtnSeqWithExercise(@PathVariable long rtnSeq);

    @Operation(summary = "단일 Routine 삭제 API입니다", description = "새로운 루틴을 추가합니다.")
    @ApiResponse(responseCode = "204", description = "OK, 정상적으로 삭제됨")
    @ApiResponse(responseCode = "404", description = "NOT FOUND, 삭제 대상 루틴이 없음")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<RoutineDTO> deleteOneRoutineByRtnSeq(@PathVariable long rtnSeq);

    @Operation(summary = "단일 Routine 수정 API입니다", description = "루틴을 수정합니다.")
    @ApiResponse(responseCode = "204", description = "OK, 정상적으로 수정됨")
    @ApiResponse(responseCode = "404", description = "NOT FOUND, 수정 대상 루틴이 없음")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<RoutineDTO> updateRoutine(@PathVariable long rtnSeq, @RequestBody RoutineDTO routineDTO);
}
