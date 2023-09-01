package com.backend.hyunfit.domain.exch.mapper;

import com.backend.hyunfit.domain.exch.dto.ExerciseHistoryDTO;
import com.backend.hyunfit.domain.exch.dto.ExerciseHistorySummaryDTO;
import com.backend.hyunfit.domain.exch.dto.PeriodicRecordDTO;
import com.backend.hyunfit.global.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ExerciseHistoryMapper {
    ExerciseHistorySummaryDTO selectOneExchSummaryByMbrIdRanged(SearchDTO searchDTO);
    List<PeriodicRecordDTO> selectAllPeriodicRecordsByMbrIdRanged(SearchDTO searchDTO);
    List<Timestamp> selectAllExercisedDaysByMbrIdRanged(SearchDTO searchDTO);
    int insertOneExerciseHistory(ExerciseHistoryDTO exerciseHistoryDTO);
}
