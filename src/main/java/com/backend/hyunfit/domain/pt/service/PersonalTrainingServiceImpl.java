package com.backend.hyunfit.domain.pt.service;

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

    @Override
    public void createPt(PersonalTrainingDTO ptDTO) {
        // validation 처리
        int insertResult = personalTrainingMapper.insertOnePt(ptDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }


    @Override
    public void modifyPt(PersonalTrainingDTO ptDTO) {
        int updateResult = personalTrainingMapper.updateOnePt(ptDTO);
        if (updateResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }
    }

    @Override
    public void createPtReview(PersonalTrainingDTO ptDTO) {
        personalTrainingMapper.selectOnePtBySeq(ptDTO.getPtSeq())
                .orElseThrow(() -> BusinessException.of(ErrorCode.RESERVATION_NOT_FOUND));

        int insertResult = personalTrainingMapper.insertOnePtReview(ptDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }

    @Override
    public PersonalTrainingDTO selectOnePtBySeq(Long ptSeq) {
        PersonalTrainingDTO ptDTO = personalTrainingMapper.selectOnePtBySeq(ptSeq)
                .orElseThrow(() -> BusinessException.of(ErrorCode.RESERVATION_NOT_FOUND));
        ptDTO.setPtSeq(null);
        return ptDTO;
    }
}
