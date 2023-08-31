package com.backend.hyunfit.domain.exc.mapper;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<ExerciseDTO> selectAllExercises();

    ExerciseDTO getExerciseById(Long excSeq);

    int insertOneExercise(ExerciseDTO exercise);

    void deleteExercise(Long excSeq);
}
