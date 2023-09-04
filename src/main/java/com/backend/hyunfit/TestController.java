package com.backend.hyunfit;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mbr.mapper.MemberMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {
    private final MemberMapper memberMapper;

    @GetMapping("")
    public ResponseEntity<MemberDTO> getMember() {
        return ResponseEntity.ok(memberMapper.selectOneMemberById("sychoi")
                .orElseThrow(BusinessException.supplierOf(ErrorCode.USERID_NOT_FOUND)));
    }
}
