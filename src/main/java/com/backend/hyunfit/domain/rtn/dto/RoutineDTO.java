package com.backend.hyunfit.domain.rtn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineDTO {
    private long rtnSeq;
    private long admSeq;
    private String rtnName;
    private String rtnContent;
    private Timestamp rtnCreatedDate;
    private String rtnUrl;
    private Integer rtnTarget;
    private Integer rtnDuration;
    private Integer rtnDifficulty;
}
