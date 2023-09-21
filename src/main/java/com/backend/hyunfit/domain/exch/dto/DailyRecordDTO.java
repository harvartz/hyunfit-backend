package com.backend.hyunfit.domain.exch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyRecordDTO {
    private Timestamp day;
    private double calories;
    private int exp;
    private int cumulativeExpSum;
}
