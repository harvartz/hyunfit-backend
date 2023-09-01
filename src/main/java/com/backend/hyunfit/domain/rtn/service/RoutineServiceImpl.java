package com.backend.hyunfit.domain.rtn.service;

import com.backend.hyunfit.domain.erm.dto.ErmDTO;
import com.backend.hyunfit.domain.erm.mapper.ErmMapper;
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
    @Override
    public List<RoutineDTO> selectAllRoutineFilteredSearch(RoutineDTO routineDTO) {
        if (routineDTO.hasMissingSearchCriteria()) {
            throw BusinessException.of(ErrorCode.INVALID_INPUT_VALUE);
        }
        return routineMapper.selectAllRoutineFilteredSearch(routineDTO);
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
}
