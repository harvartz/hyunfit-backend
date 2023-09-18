package com.backend.hyunfit.domain.ptr.mapper;

import com.backend.hyunfit.domain.ptr.dto.PtrDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PtrMapper {
    List<PtrDTO> selectAllReviewsByTrnId(String trnId);
}
