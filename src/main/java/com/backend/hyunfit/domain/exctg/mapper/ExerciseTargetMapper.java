package com.backend.hyunfit.domain.exctg.mapper;

import com.backend.hyunfit.domain.exctg.dto.ExerciseTargetDTO;
import com.backend.hyunfit.global.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseTargetMapper {
    List<ExerciseTargetDTO> selectAllExerciseTargetByMbrIdRanged(SearchDTO searchDTO);
}
