package com.backend.hyunfit.domain.trn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainerDTO {
    private long trnSeq;
    private String trnId;
    private String trnPw;
    private String trnName;
}