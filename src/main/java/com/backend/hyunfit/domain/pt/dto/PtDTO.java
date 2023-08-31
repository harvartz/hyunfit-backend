package com.backend.hyunfit.domain.pt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PtDTO {
    private long ptSeq;
    private long mbrSeq;
    private long trnSeq;
    private Timestamp ptReservationDate;
    private Integer ptReservationStatus;
}
