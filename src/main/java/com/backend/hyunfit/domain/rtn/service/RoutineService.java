package com.backend.hyunfit.domain.rtn.service;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import com.backend.hyunfit.global.exception.BusinessException;

import java.util.List;

public interface RoutineService {
    /**
     * 루틴 검색 결과를 반환하는 메서드입니다.
     *
     * @param routineDTO 루틴 검색 조건을 가지고 있습니다. rtnTarget: 운동부위, rtnDuration: 운동시간, rtnDifficulty: 운동 난이도
     * @throws BusinessException 루틴 검색 결과가 없을 때 ROUTINE_NOT_FOUND 예외가 발생합니다.
     * @throws BusinessException 루틴 검색 조건이 하나라도 없을 때 INVALID_INPUT_VALUE 예외가 발생합니다.
     */
    List<RoutineDTO> selectAllRoutineFilteredSearch(RoutineDTO routineDTO);
}
