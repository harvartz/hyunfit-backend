package com.backend.hyunfit.global.security.filters;

import com.backend.hyunfit.global.security.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtFilterFactory {
    private final JwtProvider jwtProvider;
    public JwtFilter testAuthorization() {
        return new JwtFilter(jwtProvider);
    }
}