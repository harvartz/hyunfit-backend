package com.backend.hyunfit.domain.exc.mapper;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ExerciseMapper {
    List<ExerciseDTO> selectAllExercises();

    Optional<ExerciseDTO> selectOneExercise(Long excSeq);

    int insertOneExercise(ExerciseDTO exercise);

    int deleteExercise(Long excSeq);
}
