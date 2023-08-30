package com.backend.hyunfit.domain.pt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PtDTO {

    /* 멤버 시퀀스, 트레이너 시퀀스, 예약 시간(날짜, 시간),
        트레이너가 알아야 하는 사항
    */
    private Integer mbrSeq;
    private Integer trainerSeq;
}
