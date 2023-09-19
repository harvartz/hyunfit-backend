package com.backend.hyunfit.domain.trn.mapper;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TrainerMapper {
    Optional<TrainerDTO> selectOneTrainerByTrnId(String trnId);
    List<TrainerFeedbackDTO> selectNoFeedbackBytrnSeq(long trnSeq);
    List<PersonalTrainingDTO> selectAllPtByTrnSeq(long trnSeq);
}
