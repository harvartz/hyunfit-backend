package com.backend.hyunfit.domain.pt.service;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import com.backend.hyunfit.domain.pt.mapper.PtMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PtServiceImpl implements PtService {

    private final PtMapper ptMapper;

    @Override
    public void createPt(PtDTO ptDTO) {
        // validation 처리
        int insertResult = ptMapper.insertOnePt(ptDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }


    @Override
    public void modifyPt(PtDTO ptDTO) {
        int updateResult = ptMapper.updateOnePt(ptDTO);
        if (updateResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }
    }

    @Override
    public void createPtReview(PtDTO ptDTO) {
        ptMapper.selectOnePtBySeq(ptDTO.getPtSeq())
                .orElseThrow(() -> BusinessException.of(ErrorCode.RESERVATION_NOT_FOUND));

        int insertResult = ptMapper.insertOnePtReview(ptDTO);
        if (insertResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }
    }

    @Override
    public PtDTO selectOnePtBySeq(Long ptSeq) {
        PtDTO ptDTO = ptMapper.selectOnePtBySeq(ptSeq)
                .orElseThrow(() -> BusinessException.of(ErrorCode.RESERVATION_NOT_FOUND));
        ptDTO.setPtSeq(null);
        return ptDTO;
    }
}
