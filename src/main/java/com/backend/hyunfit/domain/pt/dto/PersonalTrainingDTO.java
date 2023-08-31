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
public class PersonalTrainingDTO {
    private Long ptSeq;
    private Long mbrSeq;
    private Long trnSeq;
    private Timestamp ptReservationDate;
    private Integer ptReservationStatus;
    private String ptrContent;
    private Double ptrRating;
}
