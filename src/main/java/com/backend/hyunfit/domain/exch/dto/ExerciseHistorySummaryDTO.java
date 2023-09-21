package com.backend.hyunfit.domain.exch.dto;

import com.backend.hyunfit.domain.exctg.dto.ExerciseTargetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseHistorySummaryDTO {
    private String mbrId;
    private double totalCalories;
    private int totalExerciseTimeSeconds;
    private int totalExcellentCount;
    private int totalGoodCount;
    private int totalBadCount;
    private List<ExerciseTargetDTO> exerciseTargets;
    private List<String> exercisedDays;
    private List<DailyRecordDTO> dailyRecords;
}
