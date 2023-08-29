package com.backend.hyunfit.domain.auth.controller;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth Controller", description = "인증관련 컨트롤러")
public interface AuthController {

    @Operation(summary="Member의 접근권한 생성", description = "Member의 아이디와 비밀번호를 확인한 뒤 일치한다면 멤버정보를 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<AuthDTO> createMemberAuth(AuthDTO authVO);
}
