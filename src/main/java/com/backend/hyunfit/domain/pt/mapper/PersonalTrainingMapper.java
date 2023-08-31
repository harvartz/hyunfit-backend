package com.backend.hyunfit.domain.pt.mapper;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface PersonalTrainingMapper {
    int insertOnePt(PersonalTrainingDTO ptDTO);
    int updateOnePt(PersonalTrainingDTO ptDTO);
    int insertOnePtReview(PersonalTrainingDTO ptDTO);
    Optional<PersonalTrainingDTO> selectOnePtBySeq(Long ptSeq);
}
