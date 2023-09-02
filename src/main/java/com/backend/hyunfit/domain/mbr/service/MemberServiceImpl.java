package com.backend.hyunfit.domain.mbr.service;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mbr.mapper.MemberMapper;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Log4j2
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


    @Override
    public MemberDTO selectAllMemberPtBySeq(String mbrSeq) {
        log.info("=============== selectAllMemberPtBySeq : Sevice " + mbrSeq);
        MemberDTO memberDTO = memberMapper.selectOneMemberById(mbrSeq)
                .orElseThrow(() -> BusinessException.of(ErrorCode.USERID_NOT_FOUND));


        List<PersonalTrainingDTO> personalTrainingDTO = memberMapper.selectAllMemberPtBySeq(mbrSeq);
        memberDTO.setPersonalTrainingDTOList(personalTrainingDTO);
        return memberDTO;
    }
}
