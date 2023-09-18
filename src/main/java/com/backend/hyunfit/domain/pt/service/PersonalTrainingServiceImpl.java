package com.backend.hyunfit.domain.pt.service;

import com.backend.hyunfit.domain.mbr.mapper.MemberMapper;
import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.domain.pt.mapper.PersonalTrainingMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalTrainingServiceImpl implements PersonalTrainingService {

    private final PersonalTrainingMapper personalTrainingMapper;
    private final MemberMapper memberMapper;

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
    public void modifyPt(PersonalTrainingDTO personalTrainingDTO) {
        int updateResult = personalTrainingMapper.updateOnePt(personalTrainingDTO);
        if (updateResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }
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
