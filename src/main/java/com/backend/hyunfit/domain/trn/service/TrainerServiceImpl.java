package com.backend.hyunfit.domain.trn.service;

import com.backend.hyunfit.domain.pt.mapper.PersonalTrainingMapper;
import com.backend.hyunfit.domain.ptr.dto.PtrDTO;
import com.backend.hyunfit.domain.ptr.mapper.PtrMapper;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.mapper.TrainerMapper;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import com.backend.hyunfit.global.common.Utils;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {
    private final TrainerMapper trainerMapper;
    private final TrainerFeedbackMapper trainerFeedbackMapper;
    private final PersonalTrainingMapper personalTrainingMapper;
    private final PtrMapper ptrMapper;
    @Override
    public TrainerDTO selectAllPtBytrnSeq(String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        long trnSeqL = Long.parseLong(trnSeq);
        trainerDTO.setPtList(personalTrainingMapper.selectAllPtBytrnSeq(trnSeqL));
        if(trainerDTO.getPtList()==null){
            throw BusinessException.of(ErrorCode.RESERVATIONLIST_NOT_FOUND);
        }
        return trainerDTO;
    }
    public TrainerDTO selectNoFeedbackBytrnSeq(String trnSeq) {
        TrainerDTO trainerDTO = new TrainerDTO();
        long trnSeqL = Long.parseLong(trnSeq);
        trainerDTO.setNoFeedbackList(trainerFeedbackMapper.selectNoFeedbackBytrnSeq(trnSeqL));
        if (trainerDTO.getNoFeedbackList() == null) {
            throw BusinessException.of(ErrorCode.NO_FEEDBACK_NOT_FOUND);
        }
        return trainerDTO;
    }

    public TrainerDTO selectOneTrnByTrnId(String trnId) {
        TrainerDTO trainer = trainerMapper.selectOneTrainerByTrnId(trnId)
                .orElseThrow(BusinessException.supplierOf(ErrorCode.USERID_NOT_FOUND));
        List<PtrDTO> reviews = ptrMapper.selectAllReviewsByTrnId(trnId);
        trainer.setReviews(reviews);
        double averageRating = reviews.stream()
                                .mapToDouble(PtrDTO::getPtrRating)
                                .average()
                                .orElse(0.0);
        averageRating = Math.round(averageRating * 10.0) / 10.0;
        trainer.setAverageReviewRating(averageRating);

        Utils.maskPassword(trainer);
        return trainer;
    }
}
