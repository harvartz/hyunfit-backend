package com.backend.hyunfit.domain.trnf.mapper;

import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrainerFeedbackMapper {
    void insertFeedback(TrainerFeedbackDTO feedbackDTO);

    List<TrainerFeedbackDTO> selectAllTrainerFeedbackByMbrSeq(long mbrSeq);
}
