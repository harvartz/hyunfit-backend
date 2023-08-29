package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.auth.dto.AuthVO;

public interface AuthService {
    AuthVO createMemberAuth(AuthVO authVO);
}
