package com.backend.hyunfit.domain.adm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {
    private long admSeq;
    private String admId;
    private String admPw;
    private String admName;
}
