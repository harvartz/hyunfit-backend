package com.backend.hyunfit.domain.auth.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDTO {
    String username;
    String password;
    boolean authenticated;
}