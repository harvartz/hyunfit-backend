package com.backend.hyunfit.domain.mev.service;

import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.domain.mev.mapper.MemberEventMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberEventServiceImpl implements MemberEventService {
    private final MemberEventMapper memberEventMapper;
    @Override
    public void createEventBymbrSeq(MemberEventDTO memberEventDTO){
        int insertMemberEvent = memberEventMapper.insertMemberEvent(memberEventDTO);
        if(insertMemberEvent==0){
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }
}
