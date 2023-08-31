package com.backend.hyunfit.domain.exercise.mapper;

import com.backend.hyunfit.domain.exercise.dto.ExerciseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ExerciseMapper {
    List<ExerciseDTO> selectAllExercises();

    ExerciseDTO getExerciseById(Long excSeq);

    int insertOneExercise(ExerciseDTO exercise);

    void deleteExercise(Long excSeq);
}
