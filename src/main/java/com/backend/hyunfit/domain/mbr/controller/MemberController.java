package com.backend.hyunfit.domain.mbr.controller;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Member Controller", description = "멤버관련 컨트롤러")
public interface MemberController {
    @Operation(summary="Member 업데이트", description = "Member의 포인트, 히스토리, 몸무게, 설문 데이터 업데이트시 사용")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")

    ResponseEntity<MemberDTO> updateOneMemberById(@PathVariable String mbrId,
                                                  @RequestBody MemberDTO memberDTO);

    @Operation(summary="Member의 데이터 조회", description = "Member의 전체 데이터를 조회합니다. 암호 제외")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")

    ResponseEntity<MemberDTO> selectOneMemberById(String mbrId);
}
