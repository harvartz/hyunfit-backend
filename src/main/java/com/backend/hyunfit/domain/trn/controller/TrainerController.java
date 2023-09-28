package com.backend.hyunfit.domain.trn.controller;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.pt.dto.TimeslotDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerSearchDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.global.dto.SearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;


@Tag(name="Trainer Controller", description = "트레이너 백오피스관련 컨트롤러")
public interface TrainerController {

    @Operation(summary = "Trainer의 레슨데이터 전체조회", description = "trnSeq를 확인 후 해당 trainer의 레슨현황전체를 List<PersonalTrainingDTO>로 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<List<PersonalTrainingDTO>> findAllPtBytrnSeq(String trnSeq, Timestamp startDate, Timestamp endDate);

    @Operation(summary = "트레이너의 작성되지않은 피드백 전체조회", description = "trnSeq를 확인 후 해당 trainer의 피드백 중 작성되지않은 피드백을 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<List<TrainerFeedbackDTO>> findNoFeedbackBytrnSeq(String trnSeq, Timestamp startDate, Timestamp endDate);

    @Operation(summary = "트레이너 조회", description = "trnId로 Trainer 조회.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<TrainerDTO> selectOneTrnByTrnId(@PathVariable String trnId);

    @Operation(summary = "예약이 꽉 찬 날들 조회", description = "예약이 불가능한 날들을 리스트로 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<TimeslotDTO> selectFullyReservedDaysByMonth(@PathVariable String trnId,
                                                                     @RequestParam Timestamp startDate,
                                                                     @RequestParam Timestamp endDate);

    @Operation(summary = "예약이 꽉 찬 시간 조회", description = "예약이 불가능한 시간들 리스트로 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<TimeslotDTO> selectAllReservedTimeslotsByDay(@PathVariable String trnId,
                                                                        @RequestParam Timestamp startDate,
                                                                        @RequestParam Timestamp endDate);

    @Operation(summary = "트레이너 검색", description = "조건에 맞는 트레이너 전체조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    ResponseEntity<List<TrainerDTO>> selectManyTrnFilteredWithOffset(TrainerSearchDTO trainerSearchDTO);

}
