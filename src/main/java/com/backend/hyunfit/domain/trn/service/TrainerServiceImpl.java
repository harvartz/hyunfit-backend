package com.backend.hyunfit.domain.trn.service;

import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.mapper.TrainerMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {
    private final TrainerMapper trainerMapper;
    @Override
    public TrainerDTO selectAllPtBytrnSeq(String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        long trnSeqL = Long.parseLong(trnSeq);
        trainerDTO.setPtList(trainerMapper.selectAllPtBytrnSeq(trnSeqL));
        if(trainerDTO.getPtList()==null){
            throw BusinessException.of(ErrorCode.RESERVATIONLIST_NOT_FOUND);
        }
        return trainerDTO;
    }
    public TrainerDTO selectNoFeedbackBytrnSeq(String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        long trnSeqL = Long.parseLong(trnSeq);
        trainerDTO.setNoFeedbackList(trainerMapper.selectNoFeedbackBytrnSeq(trnSeqL));
        if(trainerDTO.getNoFeedbackList()==null){
            throw BusinessException.of(ErrorCode.NO_FEEDBACK_NOT_FOUND);
        }
        return trainerDTO;
    }

}
