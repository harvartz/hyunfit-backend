package com.backend.hyunfit.domain.openvidu.controller;

import com.backend.hyunfit.domain.openvidu.dto.OpenViduDTO;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "OpenVidu Controller", description = "화상채팅 관련 컨트롤러")
public interface OpenViduContoller {
    @Operation(summary="화상채팅세션 생성", description = "예약번호를 확인하여 해당 화상채팅의 세션을 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<OpenViduDTO> intializeSession(OpenViduDTO openViduDTO) throws OpenViduJavaClientException, OpenViduHttpException;
    ResponseEntity<OpenViduDTO> createConnection(String ptSeq) throws OpenViduJavaClientException, OpenViduHttpException;
}
