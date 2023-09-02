package com.backend.hyunfit.domain.mbr.mapper;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<MemberDTO> selectOneMemberById(String mbrId);
    int updateOneMemberById(MemberDTO memberDTO);
    List<PersonalTrainingDTO> selectAllMemberPtBySeq(String mbrSeq);
}
