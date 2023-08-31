package com.backend.hyunfit.domain.mbr.service;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mbr.mapper.MemberMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Transactional
    @Override
    public void updateOneMemberById(MemberDTO memberDTO) {
        // 멤버 mbrId 조회 검증
        memberMapper.selectOneMemberById(memberDTO.getMbrId())
                .orElseThrow(() -> BusinessException.of(ErrorCode.USERID_NOT_FOUND));


        int updateResult = memberMapper.updateOneMemberById(memberDTO);
        if (updateResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }
    }

    @Override
    public MemberDTO selectOneMemberById(String mbrId) {
        MemberDTO memberDTO = memberMapper.selectOneMemberById(mbrId)
                .orElseThrow(() -> BusinessException.of(ErrorCode.USERID_NOT_FOUND));
        // 사용자 암호 null 처리
        memberDTO.setMbrPw(null);
        return memberDTO;
    }
}
