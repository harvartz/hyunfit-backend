package com.backend.hyunfit.domain.adm.controller;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "Admin Controller", description = "관리자관련 컨트롤러")
public interface AdminController {
    @Operation(summary="Admin의 데이터 조회", description = "Admin의 전체 데이터를 조회합니다. 암호 제외")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    AdminDTO selectOneTrainerByToken(@RequestHeader("authorization") String authorizationHeader);

}
