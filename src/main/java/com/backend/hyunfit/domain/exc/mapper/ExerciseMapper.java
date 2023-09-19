package com.backend.hyunfit.domain.exc.mapper;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.dto.ExerciseInTargetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ExerciseMapper {

    @ResultMap("ExerciseResultMap")
    List<ExerciseDTO> selectAllExercises();

    @ResultMap("ExerciseResultMap")
    Optional<ExerciseDTO> selectOneExercise(Long excSeq);

    void insertOneExercise(ExerciseDTO exercise);

    void insertExerciseTarget(ExerciseInTargetDTO exerciseInTargetDTO);

    int deleteExercise(Long excSeq);

    List<ExerciseDTO> selectAllExercisesOfRoutineByRtnSeq(long rtnSeq);
}
