package com.backend.hyunfit.domain.exch.mapper;

import com.backend.hyunfit.domain.exch.dto.ExerciseHistoryDTO;
import com.backend.hyunfit.domain.exch.dto.ExerciseHistorySummaryDTO;
import com.backend.hyunfit.domain.exch.dto.DailyRecordDTO;
import com.backend.hyunfit.global.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Mapper
public interface ExerciseHistoryMapper {
    Optional<ExerciseHistorySummaryDTO> selectOneExchSummaryByMbrIdRanged(SearchDTO searchDTO);
    List<DailyRecordDTO> selectAllDailyRecordsByMbrIdRanged(SearchDTO searchDTO);
    List<String> selectAllExercisedDaysByMbrIdRanged(SearchDTO searchDTO);
    int insertOneExerciseHistory(ExerciseHistoryDTO exerciseHistoryDTO);
}
