package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import com.backend.hyunfit.domain.adm.mapper.AdminMapper;
import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mbr.mapper.MemberMapper;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;
import com.backend.hyunfit.domain.trn.mapper.TrainerMapper;
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
    private final TrainerMapper trainerMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AuthDTO createMemberAuth(AuthDTO authDTO) {
        MemberDTO memberDTO = memberMapper.selectOneMemberById(authDTO.getUsername())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_UNAUTHORIZED));
        validate(authDTO, memberDTO.getMbrPw());
        return authDTO;
    }

    @Override
    public AuthDTO createTrainerAuth(AuthDTO authDTO) {
        TrainerDTO trainerDTO = trainerMapper.selectOneTrainerByTrnId(authDTO)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_UNAUTHORIZED));
        validate(authDTO, trainerDTO.getTrnPw());
        return authDTO;
    }

    @Override
    public AuthDTO createAdminAuth(AuthDTO authDTO) {
        AdminDTO adminDTO = adminMapper.selectOneAdminByAdmId(authDTO.getUsername())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_UNAUTHORIZED));
        validate(authDTO, adminDTO.getAdmPw());
        return authDTO;
    }

    public void validate(AuthDTO authDTO, String password) {
        authDTO.setAuthenticated(false); // 인증에 실패해도 Authenticated가 true일 경우를 방지하기 위함. 필수코드는 아님
        if (!bCryptPasswordEncoder.matches(authDTO.getPassword(), password)) {
            throw new BusinessException(ErrorCode.USER_UNAUTHORIZED);
        }
        authDTO.setAuthenticated(true);
        authDTO.setPassword(null);
    }
}