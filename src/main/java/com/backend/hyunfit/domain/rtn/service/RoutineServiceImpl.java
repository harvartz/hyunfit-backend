package com.backend.hyunfit.domain.rtn.service;

import com.backend.hyunfit.domain.erm.dto.ErmDTO;
import com.backend.hyunfit.domain.erm.mapper.ErmMapper;
import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.mapper.ExerciseMapper;
import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import com.backend.hyunfit.domain.rtn.dto.RoutineSearchDTO;
import com.backend.hyunfit.domain.rtn.mapper.RoutineMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoutineServiceImpl implements RoutineService {
    private final RoutineMapper routineMapper;
    private final ErmMapper ermMapper;
    private final ExerciseMapper exerciseMapper;

    @Override
    public List<RoutineDTO> selectAllRoutineSearch(RoutineSearchDTO routineDTO) {
        if (routineDTO.getFindExercises() == null) routineDTO.setFindExercises(true);
        List<RoutineDTO> routines = routineMapper.selectAllRoutineSearch(routineDTO);

        if (!routineDTO.getFindExercises()) return routines;

        for (RoutineDTO routine : routines) {
            List<ExerciseDTO> exercises = exerciseMapper.selectAllExercisesOfRoutineByRtnSeq(routine.getRtnSeq());
            routine.setExercises(exercises);

            // 새로운 필드를 계산
            double rtnDurationInMin = 0.0;
            int rtnCaloriesBurnt = 0;
            for (ExerciseDTO exercise : exercises) {
                rtnDurationInMin += exercise.getExcSetCount() * exercise.getExcTimePerSetInSec();
                rtnCaloriesBurnt += (int) (exercise.getExcCaloriesPerRep() * exercise.getExcSetCount());
            }

            rtnDurationInMin = Math.round((rtnDurationInMin / 60));
            // 계산된 필드를 RoutineDTO에 세팅
            routine.setRtnDurationInMin(rtnDurationInMin);
            routine.setRtnCaloriesBurnt(rtnCaloriesBurnt);

        }

        return routines;
    }

    @Override
    public int insertOneRoutine(RoutineDTO routineDTO) {

        int insertResult = routineMapper.insertOneRoutine(routineDTO);
        if (insertResult == 0 || routineDTO.getRtnSeq() == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
        }

        List<ErmDTO> erms = ErmDTO.listFrom(
                routineDTO.getRtnSeq(),
                routineDTO.getExercises()
        );

        for (ErmDTO erm: erms) {
            int ermResult = ermMapper.insertOneErm(erm);
            if (ermResult == 0) {
                throw BusinessException.of(ErrorCode.DB_QUERY_INSERT_EXCEPTION);
            }
        }

        return insertResult;
    }

    @Override
    public RoutineDTO getOneRoutineByRtnSeqWithExercise(long rtnSeq) {
        RoutineDTO routine = routineMapper.selectOneRoutineByRtnSeq(rtnSeq)
                .orElseThrow(BusinessException.supplierOf(ErrorCode.ROUTINE_NOT_FOUND));
        List<ExerciseDTO> exercises = exerciseMapper.selectAllExercisesOfRoutineByRtnSeq(rtnSeq);
        routine.setExercises(exercises);

        return routine;
    }

    @Override
    public int deleteOneRoutineByRtnSeq(long rtnSeq) {
        // 삭제가능여부 체크
        routineMapper.selectOneRoutineByRtnSeq(rtnSeq)
                .orElseThrow(BusinessException.supplierOf(ErrorCode.ROUTINE_NOT_FOUND));

        return routineMapper.deleteOneRoutineByRtnSeq(rtnSeq);
    }

    @Transactional
    @Override
    public int updateRoutine(long rtnSeq, RoutineDTO routineDTO) {
        // 수정가능여부 체크
        routineMapper.selectOneRoutineByRtnSeq(rtnSeq)
                .orElseThrow(BusinessException.supplierOf(ErrorCode.ROUTINE_NOT_FOUND));

        // Routine 정보 업데이트
        int updateResult = routineMapper.updateOneRoutine(rtnSeq, routineDTO);
        if (updateResult == 0) {
            throw BusinessException.of(ErrorCode.DB_QUERY_UPDATE_EXCEPTION);
        }

        ermMapper.deleteAllErmsByRtnSeq(rtnSeq); // 기존 운동들 삭제

        List<ErmDTO> erms = ErmDTO.listFrom(
                routineDTO.getRtnSeq(),
                routineDTO.getExercises()
        );
        for (ErmDTO erm : erms) {
            ermMapper.insertOneErm(erm); // 새로운 운동들 삽입
        }

        return updateResult;
    }

}
