package com.backend.hyunfit.domain.mev.controller;

import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.domain.mev.service.MemberEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member-event")
public class MemberEventControllerImpl implements MemberEventController{
    private final MemberEventService memberEventService;
    @Override
    @PostMapping
    public ResponseEntity<MemberEventDTO> createEventBymbrSeq(@RequestBody MemberEventDTO memberEventDTO){
        memberEventService.createEventBymbrSeq(memberEventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberEventDTO);
    }

    @Override
    @GetMapping("/{mbrSeq}")
    public ResponseEntity<List<MemberEventDTO>> selectMemberEvent(@PathVariable Integer mbrSeq) {
        List<MemberEventDTO> memberEvents = memberEventService.selectMemberEvent(mbrSeq);
        return ResponseEntity.ok(memberEvents);
    }

}
