package com.backend.hyunfit.domain.trn.mapper;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.pt.dto.PtDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TrainerMapper {
    Optional<TrainerDTO> selectOneTrainerByTrnId(AuthDTO authDTO);
    List<PtDTO> selectAllPtBytrnSeq(long trnSeq);
}
