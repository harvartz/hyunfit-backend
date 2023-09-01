package com.backend.hyunfit.domain.rtn.controller;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Routine Controller", description = "Routine 관련 컨트롤러")
public interface RoutineController {
    @Operation(summary = "Routine 검색 API입니다", description = "검색 조건에 맞는 모든 루틴을 반환합니다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST, 올바른 검색 조건이 아님")
    @ApiResponse(responseCode = "404", description = "NOT FOUND, 검색 조건에 맞는 루틴이 없음")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<List<RoutineDTO>> selectAllRoutineFilteredSearch(RoutineDTO routineDTO);

}
