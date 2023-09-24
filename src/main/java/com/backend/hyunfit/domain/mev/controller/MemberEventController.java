package com.backend.hyunfit.domain.mev.controller;


import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "MemberEvent Controller", description = "멤버 이벤트관련 컨트롤러")
public interface MemberEventController {
    @Operation(summary="MemberEvent 생성", description = "Member의 경험치,포인트 생성시 사용")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<MemberEventDTO> createEventBymbrSeq(@RequestBody MemberEventDTO memberEventDTO);

    @Operation(summary="MemberEvent 조회", description = "Member의 경험치,포인트 획득내역 조회 1: 경험치, 2:포인트")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<List<MemberEventDTO>> selectMemberEvent(@PathVariable Integer mbrSeq,  @PathVariable Integer mevType);
}
