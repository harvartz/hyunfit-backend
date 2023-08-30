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
        int updateResult = memberMapper.updateOneMemberById(memberDTO);
        if (updateResult == 0) {
            throw new BusinessException(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }
    }
}
