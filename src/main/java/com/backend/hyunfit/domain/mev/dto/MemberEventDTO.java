package com.backend.hyunfit.domain.mev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEventDTO {
    private Integer mbrSeq;
    private Integer mevType;
    private Integer mevAmount;
    private Timestamp mevCreationDate;
}
