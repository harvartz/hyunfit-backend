package com.backend.hyunfit.domain.mbr.mapper;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<MemberDTO> selectOneMemberById(String mbrId);
    Optional<MemberDTO> selectOneMemberBySeq(long mbrSeq);
    int updateOneMemberById(MemberDTO memberDTO);
}
