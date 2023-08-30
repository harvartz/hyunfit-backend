package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.domain.member.dto.MemberDTO;
import com.backend.hyunfit.domain.member.mapper.MemberMapper;
import com.backend.hyunfit.domain.trainer.dto.TrainerDTO;
import com.backend.hyunfit.domain.trainer.mapper.TrainerMapper;
import com.backend.hyunfit.global.exception.BusinessException;
import com.backend.hyunfit.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberMapper memberMapper;
    private final TrainerMapper trainerMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AuthDTO createMemberAuth(AuthDTO authDTO) {
        MemberDTO memberDTO = memberMapper.selectOneMemberByMbrId(authDTO.getUsername())
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        validate(authDTO, memberDTO.getMbrPw());
        return authDTO;
    }


    @Override
    public AuthDTO createTrainerAuth(AuthDTO authDTO) {
        TrainerDTO trainerDTO = trainerMapper.selectOneTrainerByTrnId(authDTO)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        validate(authDTO, trainerDTO.getTrnPw());
        return authDTO;
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