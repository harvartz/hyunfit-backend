package com.backend.hyunfit.domain.rtn.service;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import com.backend.hyunfit.domain.rtn.mapper.RoutineMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {
    private final RoutineMapper routineMapper;


    public boolean hasMissingSearchCriteria(RoutineDTO routineDTO) {
        return routineDTO.getRtnTarget() == null ||
                routineDTO.getRtnDifficulty() == null ||
                routineDTO.getRtnDuration() == null;
    }
    @Override
    public List<RoutineDTO> selectAllRoutineFilteredSearch(RoutineDTO routineDTO) {
        if (hasMissingSearchCriteria(routineDTO)) {
            throw BusinessException.of(ErrorCode.INVALID_INPUT_VALUE);
        }
        return routineMapper.selectAllRoutineFilteredSearch(routineDTO);
    }
}
