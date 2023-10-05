package com.backend.hyunfit.domain.mbr.controller;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

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
    ResponseEntity<MemberDTO> selectOneMemberBymbrSeq(String mbrSeq);

    @Operation(summary="Member의 예약 데이터 조회", description = "Member의 전체 예약되어 있는 데이터를 조회합니다.")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<MemberDTO> selectAllMemberPtBySeq(@PathVariable long mbrSeq,
                                                     @RequestParam int page,
                                                     @RequestParam String order,
                                                     @RequestParam String ptReservationStatus);

    @Operation(summary="Member의 예약 전체 갯수 리뷰 데이터 조회", description = "Member의 리뷰 데이터 전체 갯수 조회합니다.")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<MemberDTO> selectPastPtCountBySeq(@PathVariable long mbrSeq);

    @Operation(summary="Member의 리포트 데이터 조회", description = "Member 하나의 Report를 조회합니다.")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<MemberDTO> selectOneMemberReportById(@PathVariable long mbrSeq,
                                                        @RequestParam Timestamp startDate,
                                                        @RequestParam Timestamp endDate);

    @Operation(summary="Member의 이벤트 데이터 조회", description = "Member 하나의 월 별 경험치, 포인트를 조회합니다.")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    ResponseEntity<List<MemberEventDTO>> selectAllMemberEventBySeq(@PathVariable long mbrSeq,
                                                        @RequestParam Timestamp startDate,
                                                        @RequestParam Timestamp endDate);

    @Operation(summary="Member의 피드백 데이터 전체 조회", description = "트레이너가 멤버에게 써준 피드백 전체 조회")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")

    ResponseEntity<MemberDTO> selectAllMemberTrnfByMbrSeq(@PathVariable long mbrSeq);

    @Operation(summary="Member의 피드백 데이터 단일 조회", description = "트레이너가 멤버에게 써준 피드백 단일 조회")

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")

    ResponseEntity<TrainerFeedbackDTO> selectOneMemberTrnfByMbrSeq(@PathVariable long mbrSeq, @RequestParam String date);
}
