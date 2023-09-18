package com.backend.hyunfit.domain.pt.mapper;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PersonalTrainingMapper {
    int insertOnePt(PersonalTrainingDTO personalTrainingDTO);
    int updateOnePt(PersonalTrainingDTO personalTrainingDTO);
    int insertOnePtReview(PersonalTrainingDTO personalTrainingDTO);
    Optional<PersonalTrainingDTO> selectOnePtByPtSeq(Long ptSeq);
    List<PersonalTrainingDTO> selectAllPtByTrnSeq(long trnSeqL);
}
