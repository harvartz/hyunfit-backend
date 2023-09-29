package com.backend.hyunfit.domain.mev.mapper;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.global.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberEventMapper {
    int insertMemberEvent(MemberEventDTO memberEventDTO);
    List<MemberEventDTO> selectMemberEvent(Integer mbrSeq, Integer mevType);
    List<MemberEventDTO> selectAllMemberEventBySeq(SearchDTO searchDTO);
}
