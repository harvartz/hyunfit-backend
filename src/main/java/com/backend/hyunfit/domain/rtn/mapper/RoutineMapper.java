package com.backend.hyunfit.domain.rtn.mapper;

import com.backend.hyunfit.domain.rtn.dto.RoutineDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoutineMapper {
    List<RoutineDTO> selectAllRoutineFilteredSearch(RoutineDTO routineDTO);
}
