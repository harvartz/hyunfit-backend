package com.backend.hyunfit.domain.mbr.controller;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mbr.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberControllerImpl implements MemberController {
    private final MemberService memberService;

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
    @GetMapping("/{mbrId}/personal-trainings")
    public ResponseEntity<MemberDTO> selectAllMemberPtBySeq(@PathVariable String mbrId) {
        log.info("=============== selectAllMemberPtBySeq : controller");
        return ResponseEntity.ok(memberService.selectAllMemberPtBySeq(mbrId));
    }
}

