package com.backend.hyunfit.domain.mbr.controller;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mbr.service.MemberService;
import com.backend.hyunfit.global.dto.SearchDTO;
import com.backend.hyunfit.global.security.provider.JwtProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;

@CrossOrigin(origins = "${vue.url}")
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/members")
public class MemberControllerImpl implements MemberController {
    private final MemberService memberService;
    private final JwtProvider jwtProvider;
    @GetMapping("/me")
    public MemberDTO selectOneMemberByToken(@RequestHeader("authorization") String authorizationHeader){
        AuthDTO authDTO = jwtProvider.getUserInfo(authorizationHeader);
        return memberService.selectOneMemberById(authDTO.getUsername());
    }

    @Override
    @PutMapping("/{mbrId}")
    public ResponseEntity<MemberDTO> updateOneMemberById(@PathVariable String mbrId,
                                                         @RequestBody MemberDTO memberDTO) {

        memberDTO.setMbrId(mbrId);
        memberService.updateOneMemberById(memberDTO);

        return ResponseEntity.ok(memberDTO);
    }

    @Override
    @GetMapping("/{mbrId}")
    public ResponseEntity<MemberDTO> selectOneMemberById(@PathVariable String mbrId) {
        return ResponseEntity.ok(memberService.selectOneMemberById(mbrId));
    }

    @Override
    @GetMapping("/{mbrSeq}/personal-trainings")
    public ResponseEntity<MemberDTO> selectAllMemberPtBySeq(@PathVariable long mbrSeq,
                                                            @RequestParam int page,
                                                            @RequestParam String order,
                                                            @RequestParam String ptReservationStatus) {
        return ResponseEntity.ok(memberService.selectAllMemberPtBySeq(mbrSeq, page, order, ptReservationStatus));
    }

    @Override
    @GetMapping("/{mbrSeq}/personal-trainings/count")
    public ResponseEntity<MemberDTO> selectPastPtCountBySeq(@PathVariable long mbrSeq) {
        return ResponseEntity.ok(memberService.selectPastPtCountBySeq(mbrSeq));
    }


    @Override
    @GetMapping("/{mbrSeq}/report")
    public ResponseEntity<MemberDTO> selectOneMemberReportById(@PathVariable long mbrSeq,
                                                               @RequestParam Timestamp startDate,
                                                               @RequestParam Timestamp endDate) {
        SearchDTO searchDTO = SearchDTO.of(mbrSeq, startDate, endDate);
        MemberDTO memberDTO = memberService.selectOneMemberReportById(searchDTO);
        return ResponseEntity.ok(memberDTO);
    }

    @Override
    @GetMapping("/{mbrSeq}/feedbacks")
    public ResponseEntity<MemberDTO> selectAllMemberTrnfByMbrSeq(@PathVariable long mbrSeq) {
        MemberDTO memberDTO = memberService.selectAllMemberTrnfByMbrSeq(mbrSeq);
        return ResponseEntity.ok(memberDTO);
    }

    @Override
    @GetMapping("/{mbrSeq}/feedback")
    public ResponseEntity<String> selectOneMemberTrnfByMbrSeq(@PathVariable long mbrSeq, @RequestParam String date) {
        return ResponseEntity.ok(memberService.selectOneMemberTrnfByMbrSeq(mbrSeq,date));
    }

}

