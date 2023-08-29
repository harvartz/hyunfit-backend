package com.backend.hyunfit.domain.member.mapper;

import com.backend.hyunfit.domain.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<MemberDTO> selectOneMemberByMbrId(String mbrId);
}
