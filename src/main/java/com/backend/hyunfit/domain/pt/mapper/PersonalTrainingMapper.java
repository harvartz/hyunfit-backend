package com.backend.hyunfit.domain.pt.mapper;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface PtMapper {
    int insertOnePt(PtDTO ptDTO);
    int updateOnePt(PtDTO ptDTO);
    int insertOnePtReview(PtDTO ptDTO);
    Optional<PtDTO> selectOnePtBySeq(Long ptSeq);
}
