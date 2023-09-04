package com.backend.hyunfit.domain.rtn.mapper;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RoutineMapper {
    List<RoutineDTO> selectAllRoutineFilteredSearch(RoutineDTO routineDTO);
    int insertOneRoutine(RoutineDTO routineDTO);
    Optional<RoutineDTO> selectOneRoutineByRtnSeq(long rtnSeq);
    int deleteOneRoutineByRtnSeq(long rtnSeq);
}
