package com.backend.hyunfit.domain.trnf.controller;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "TrainerFeedback Controller", description = "피드백관련 컨트롤러")
public interface TrainerFeedbackController {

    @Operation(summary="Feedback 등록", description = "PT가 끝나면 피드백DB에 등록")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    TrainerFeedbackDTO createFeedback(@RequestBody TrainerFeedbackDTO feedbackDTO);
    
    @Operation(summary="gpt 응답 가져오기", description = "피드백에서 gpt 응답 가져오기")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "BAD REQUEST")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<TrainerFeedbackDTO> getGptFeedback(@RequestBody TrainerFeedbackDTO dto);
}