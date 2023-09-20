package com.backend.hyunfit.domain.rtn.dto;

import com.backend.hyunfit.domain.exc.dto.ExerciseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineDTO {
    private long rtnSeq;
    private long admSeq;
    private String rtnName;
    private String rtnContent;
    private Timestamp rtnCreatedDate;
    private Integer rtnTarget;
    private Integer rtnDuration;
    private Integer rtnExperienceLevel;
    private Integer rtnGoal;
    private Integer rtnKneeHealthConsidered;
    private Integer rtnNoiseConsidered;
    private Integer rtnLongSitter;
    private Integer rtnNeckShoulderFocused;
    private Integer rtnBackDiskConsidered;
    private Integer rtnRewardPoint;
    private List<ExerciseDTO> exercises;
    private Double rtnDurationInMin;
    private Integer rtnCaloriesBurnt;

    public boolean hasMissingSearchCriteria() {
        return rtnTarget == null ||
                rtnDuration == null ||
                rtnExperienceLevel == null;
    }
}
