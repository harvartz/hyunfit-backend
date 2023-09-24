package com.backend.hyunfit.domain.mev.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.domain.mev.mapper.MemberEventMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<MemberEventDTO> selectMemberEvent(Integer mbrSeq) {
        try {
            return memberEventMapper.selectMemberEvent(mbrSeq);
        } catch (Exception e) {
            throw BusinessException.of(ErrorCode.EVENT_NOT_FOUND);
        }
    }
}
