package com.backend.hyunfit.domain.exch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodicRecordDTO {
    private Timestamp statPeriod;
    private double caloriesSum;
    private int expSum;
    private int cumulativeExpSum;
}
