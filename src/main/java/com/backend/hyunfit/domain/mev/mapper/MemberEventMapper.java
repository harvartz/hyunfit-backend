package com.backend.hyunfit.domain.mev.mapper;

import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberEventMapper {
    int insertMemberEvent(MemberEventDTO memberEventDTO);
}
