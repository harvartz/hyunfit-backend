package com.backend.hyunfit.domain.openvidu.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenViduDTO {
    String ptSeq;
    String sessionId;
    String token;

}
