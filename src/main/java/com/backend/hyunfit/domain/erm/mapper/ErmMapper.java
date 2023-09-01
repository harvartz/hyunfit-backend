package com.backend.hyunfit.domain.erm.mapper;

import com.backend.hyunfit.domain.erm.dto.ErmDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ErmMapper {
    int insertBulkErm(List<ErmDTO> erms);
}
