package com.backend.hyunfit.domain.rtn.service;

import com.backend.hyunfit.domain.erm.dto.ErmDTO;
import com.backend.hyunfit.domain.erm.mapper.ErmMapper;
import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import com.backend.hyunfit.domain.exc.mapper.ExerciseMapper;
import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
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
    public List<RoutineDTO> selectAllRoutineSearch(RoutineDTO routineDTO) {
        List<RoutineDTO> routines = routineMapper.selectAllRoutineSearch(routineDTO);
        for (RoutineDTO routine : routines) {
            List<ExerciseDTO> exercises = exerciseMapper.selectAllExercisesOfRoutineByRtnSeq(routine.getRtnSeq());
            routine.setExercises(exercises);
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
}
