package com.backend.hyunfit.domain.rtn.service;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import com.backend.hyunfit.domain.rtn.dto.RoutineSearchDTO;
import com.backend.hyunfit.global.exception.BusinessException;

import java.util.List;

public interface RoutineService {

    /*
     * 루틴 검색 결과를 반환하는 메서드입니다.
     *
     * @param routineDTO 루틴 검색 조건을 가지고 있습니다. rtnTarget: 운동부위, rtnDuration: 운동시간, rtnDifficulty: 운동 난이도
     * @throws BusinessException 루틴 검색 결과가 없을 때 ROUTINE_NOT_FOUND 예외가 발생합니다.
     * @throws BusinessException 루틴 검색 조건이 하나라도 없을 때 INVALID_INPUT_VALUE 예외가 발생합니다.
     * 변동 사항 : 검색 조건이 모두 null 일 경우 모든 루틴을 반환 합니다.
     */
    List<RoutineDTO> selectAllRoutineSearch(RoutineSearchDTO routineDTO);

    /**
     * 루틴을 추가하는 메서드입니다.
     *
     * @param routineDTO 추가될 루틴의 데이터를 가지고 있습니다.
     */
    int insertOneRoutine(RoutineDTO routineDTO);

    /**
     * 단일 루틴 조회 메서드입니다. 루틴 정보, 매핑되어있는 운동(ExerciseDTO) 리스트 데이터를 담고있는 RoutineDTO를 반환합니다.
     *
     * @param rtnSeq 루틴의 고유 Seq값입니다.
     * @throws BusinessException 삭제할 대상 루틴이 없을 때 ROUTINE_NOT_FOUND 예외가 발생합니다.
     */
    RoutineDTO getOneRoutineByRtnSeqWithExercise(long rtnSeq);

    /**
     * 루틴 검색 결과를 반환하는 메서드입니다.
     *
     * @param rtnSeq 루틴의 고유 Seq값입니다.
     * @throws BusinessException 삭제할 대상 루틴이 없을 때 ROUTINE_NOT_FOUND 예외가 발생합니다.
     */
    int deleteOneRoutineByRtnSeq(long rtnSeq);

    /**
     * 루틴 수정 메서드입니다.
     *
     * @param rtnSeq 루틴의 고유 Seq값입니다.
     * @throws BusinessException 수정할 대상 루틴이 없을 때 ROUTINE_NOT_FOUND 예외가 발생합니다.
     */
    int updateRoutine(long rtnSeq, RoutineDTO routineDTO);
}