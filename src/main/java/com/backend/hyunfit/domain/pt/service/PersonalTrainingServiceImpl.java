package com.backend.hyunfit.domain.pt.service;

import com.backend.hyunfit.domain.mbr.mapper.MemberMapper;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.pt.mapper.PersonalTrainingMapper;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.domain.trnf.mapper.TrainerFeedbackMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonalTrainingServiceImpl implements PersonalTrainingService {

    private final PersonalTrainingMapper personalTrainingMapper;
    private final MemberMapper memberMapper;
    private final TrainerFeedbackMapper trainerFeedbackMapper;

    @Override
    public void createPt(PersonalTrainingDTO personalTrainingDTO) {
        // validation 처리
        // 같은 시각에 예약이 있으면 오류 발생
        
        int insertResult = personalTrainingMapper.insertOnePt(personalTrainingDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }


    @Override
    @Transactional
    public void modifyPt(PersonalTrainingDTO personalTrainingDTO) {
        int updateResult = personalTrainingMapper.updateOnePt(personalTrainingDTO);

        if (updateResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }
        PersonalTrainingDTO personalTraining = personalTrainingMapper.selectOnePtByPtSeq(personalTrainingDTO.getPtSeq())
                .orElseThrow(BusinessException.supplierOf(ErrorCode.RESERVATION_NOT_FOUND));
        TrainerFeedbackDTO feedbackDTO = new TrainerFeedbackDTO();
        feedbackDTO.setMbrSeq(personalTraining.getMbrSeq());
        feedbackDTO.setTrnSeq(personalTraining.getTrnSeq());
        trainerFeedbackMapper.insertFeedback(feedbackDTO);
    }

    @Override
    public void createPtReview(PersonalTrainingDTO personalTrainingDTO) {
        personalTrainingMapper.selectOnePtByPtSeq(personalTrainingDTO.getPtSeq())
                .orElseThrow(() -> BusinessException.of(ErrorCode.RESERVATION_NOT_FOUND));

        int insertResult = personalTrainingMapper.insertOnePtReview(personalTrainingDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }

    @Override
    public PersonalTrainingDTO selectOnePtByPtSeq(Long ptSeq) {
        return personalTrainingMapper.selectOnePtByPtSeq(ptSeq)
                .orElseThrow(() -> BusinessException.of(ErrorCode.RESERVATION_NOT_FOUND));
    }

}
