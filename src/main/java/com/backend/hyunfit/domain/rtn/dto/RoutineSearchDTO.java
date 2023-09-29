package com.backend.hyunfit.domain.rtn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineSearchDTO {
    private Integer rtnTarget;
    private Integer rtnDuration;
    private Integer rtnExperienceLevel;
    private Boolean findExercises;
}
