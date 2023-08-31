package com.backend.hyunfit.domain.trn.service;

import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.mapper.TrainerMapper;
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
        return trainerDTO;
    }

}
