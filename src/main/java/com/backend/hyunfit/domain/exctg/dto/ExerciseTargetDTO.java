package com.backend.hyunfit.domain.exctg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseTargetDTO {
    private int targetArea;
    private double totalCalories;
}
