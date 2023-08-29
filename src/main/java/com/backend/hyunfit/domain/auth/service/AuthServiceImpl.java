package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.auth.dto.AuthVO;
import com.backend.hyunfit.domain.auth.mapper.AuthMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;

    @Override
    public AuthVO createMemberAuth(AuthVO authVO) {
        return authMapper.findMemberAuth(authVO)
                .orElseThrow(() -> new BusinessException(ErrorCode.CM_CODE_NOT_FOUND));
    }
}
