package com.backend.hyunfit.domain.exc.mapper;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.dto.ExerciseInTargetDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ExerciseMapper {
    List<ExerciseDTO> selectAllExercises();

    Optional<ExerciseDTO> selectOneExercise(Long excSeq);

    void insertOneExercise(ExerciseDTO exercise);

    void insertExerciseTarget(ExerciseInTargetDTO exerciseInTargetDTO);

    int deleteExercise(Long excSeq);

    List<ExerciseDTO> selectAllExercisesOfRoutineByRtnSeq(long rtnSeq);
}
