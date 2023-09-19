package com.backend.hyunfit.domain.trn.service;

import com.backend.hyunfit.domain.pt.dto.TimeslotDTO;
import com.backend.hyunfit.domain.pt.mapper.PersonalTrainingMapper;
import com.backend.hyunfit.domain.ptr.dto.PtrDTO;
import com.backend.hyunfit.domain.ptr.mapper.PtrMapper;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerSearchDTO;
import com.backend.hyunfit.domain.trn.mapper.TrainerMapper;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import com.backend.hyunfit.global.common.Utils;
import com.backend.hyunfit.global.dto.SearchDTO;
import com.backend.hyunfit.global.dto.SearchOrder;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {
    private final TrainerMapper trainerMapper;
    private final TrainerFeedbackMapper trainerFeedbackMapper;
    private final PersonalTrainingMapper personalTrainingMapper;
    private final PtrMapper ptrMapper;
    @Override
    public TrainerDTO selectAllPtByTrnSeq(String trnSeq){
        TrainerDTO trainerDTO = new TrainerDTO();
        long trnSeqL = Long.parseLong(trnSeq);
        trainerDTO.setPtList(personalTrainingMapper.selectAllPtByTrnSeq(trnSeqL));
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

    @Override
    public TimeslotDTO selectFullyReservedDaysByMonth(SearchDTO searchDTO) {
        return personalTrainingMapper.selectFullyReservedDaysByMonth(searchDTO);
    }

    @Override
    public TimeslotDTO selectAllReservedTimeslotsByDay(SearchDTO searchDTO) {
        return personalTrainingMapper.selectAllReservedTimeslotsByDay(searchDTO);
    }

    @Override
    public List<TrainerDTO> selectManyTrnFilteredWithOffset(TrainerSearchDTO searchDTO) {
        if (searchDTO.getPage() < 1)  searchDTO.setPage(1);
        if (searchDTO.getTrainerTypes() == null) searchDTO.setTrainerTypes(new ArrayList<>());
        if (searchDTO.getOrder() == null) searchDTO.setOrder(SearchOrder.ANY);
        if (searchDTO.getKeyword() == null) searchDTO.setKeyword("");
        return trainerMapper.selectManyTrnFilteredWithOffset(searchDTO);
    }
}
