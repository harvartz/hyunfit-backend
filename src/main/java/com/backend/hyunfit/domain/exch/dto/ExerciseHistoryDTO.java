package com.backend.hyunfit.domain.exch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseHistoryDTO {
    private Long exchSeq;
    private Long excSeq;
    private Long mbrSeq;
    private Timestamp exchStartTime;
    private Timestamp exchEndTime;
    private Integer exchExcelentCnt;
    private Integer exchGoodCnt;
    private Integer exchBadCnt;
    private Integer exchTotalCalories;
}
