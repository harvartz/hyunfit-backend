package com.backend.hyunfit.domain.mbr.mapper;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<MemberDTO> selectOneMemberByMbrId(String mbrId);
    int updateOneMemberById(MemberDTO memberDTO);
}
