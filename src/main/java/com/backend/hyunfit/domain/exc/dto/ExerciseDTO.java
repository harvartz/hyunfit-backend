package com.backend.hyunfit.domain.exc.dto;

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
public class ExerciseDTO {
    private Long excSeq;
    private Long admSeq;
    private String excName;
    private Integer excType;
    private String excContent;
    private Integer excDifficulty;
    private Double excCaloriesPerRep;
    private Integer excSetCount;
    private Integer excRepCountPerSet;
    private Integer excTimePerSetInSec;
    private String excUrl;
    private Timestamp excCreatedDate;
    private List<ExerciseInTargetDTO> exerciseTargets;
}

