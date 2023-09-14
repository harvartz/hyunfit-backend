package com.backend.hyunfit.domain.exc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseInTargetDTO {
    private Long excSeq;
    private int exctgArea;
    private float exctgWeight;

    // getters and setters
}
