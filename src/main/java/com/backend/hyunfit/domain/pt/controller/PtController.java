package com.backend.hyunfit.domain.pt.controller;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@Tag(name="Pt Controller", description = "pt관련 컨트롤러")
public interface PtController {
    @Operation(summary="Pt의 개인레슨을 등록하는 과정입니다", description = "개인 레슨을 등록하는 과정 중에서 비어있는 값이 있으면 다음과 같은 에러를 반환합니다")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<PtDTO> createPt(PtDTO ptDTO);

    @Operation(summary="Pt의 개인레슨 정보를 수정하는 과정입니다", description = "개인 레슨을 수정하는 과정 중에서 비어있는 값이 있으면 다음과 같은 에러를 반환합니다")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<PtDTO> modifyPt(@PathVariable long ptSeq, PtDTO ptDTO);
}