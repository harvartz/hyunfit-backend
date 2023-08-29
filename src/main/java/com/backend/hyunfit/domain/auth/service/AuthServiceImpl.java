package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.auth.mapper.AuthMapper;
import com.backend.hyunfit.domain.member.dto.MemberDTO;
import com.backend.hyunfit.domain.member.mapper.MemberMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public AuthDTO createMemberAuth(AuthDTO authDTO) {

        MemberDTO memberDTO = memberMapper.selectOneMemberByMbrId(authDTO.getMbrId())
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        if (!bCryptPasswordEncoder.matches(authDTO.getMbrPw(), memberDTO.getMbrPw())) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }

        authDTO.setAuthenticated(true);
        authDTO.setMbrPw(null);
        return authDTO;
    }
}
