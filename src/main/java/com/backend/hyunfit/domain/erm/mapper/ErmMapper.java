package com.backend.hyunfit.domain.erm.mapper;

import com.backend.hyunfit.domain.erm.dto.ErmDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ErmMapper {
    int insertOneErm(ErmDTO erm);
}
