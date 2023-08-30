package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.admin.dto.AdminDTO;
import com.backend.hyunfit.domain.admin.mapper.AdminMapper;
import com.backend.hyunfit.domain.auth.dto.AuthDTO;
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
    private final AdminMapper adminMapper;
//    private final TrainerMapper trainerMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AuthDTO createMemberAuth(AuthDTO authDTO) {
        MemberDTO memberDTO = memberMapper.selectOneMemberByMbrId(authDTO.getUsername())
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        validate(authDTO, memberDTO.getMbrPw());
        return authDTO;
    }

    @Override
    public AuthDTO createAdminAuth(AuthDTO authDTO) {
        AdminDTO adminDTO = adminMapper.selectOneAdminByAdmId(authDTO.getUsername())
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        validate(authDTO, adminDTO.getAdmPw());
        return authDTO;
    }

    @Override
    public AuthDTO createTrainerAuth(AuthDTO authDTO) {
        return null;
    }

    public void validate(AuthDTO authDTO, String password) {
        authDTO.setAuthenticated(false); // 필수코드는 아님
        if (!bCryptPasswordEncoder.matches(authDTO.getPassword(), password)) {
            throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
        }
        authDTO.setAuthenticated(true);
        authDTO.setPassword(null);
    }
}
