package com.backend.hyunfit.domain.pt.mapper;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PtMapper {
    int insertOnePt(PtDTO ptDTO);

}
