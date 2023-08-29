package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;

public interface AuthService {
    AuthDTO createMemberAuth(AuthDTO authDTO);
}
