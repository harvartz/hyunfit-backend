package com.backend.hyunfit.domain.trn.dto;

import com.backend.hyunfit.domain.pt.dto.PtDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainerDTO {
    private long trnSeq;
    private String trnId;
    private String trnPw;
    private String trnName;
    private List<PtDTO> ptList;
}