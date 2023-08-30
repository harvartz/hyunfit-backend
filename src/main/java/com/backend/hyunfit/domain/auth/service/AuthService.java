package com.backend.hyunfit.domain.auth.service;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;
import com.backend.hyunfit.global.exception.BusinessException;

public interface AuthService {

    /**
     * Member의 인증 정보를 생성하는 메서드입니다.
     *
     * @param Member의 username과 password를 담고 있는 authDTO 인증 정보 DTO 객체입니다.
     * @return 입력된 인증 정보 DTO 객체를 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없거나 비밀번호가 일치하지 않을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.MEMBER_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    AuthDTO createMemberAuth(AuthDTO authDTO);
  
    /**
     * Admin의 인증 정보를 생성하는 메서드입니다.
     *
     * @param Admin의 username과 password를 담고 있는 authDTO 인증 정보 DTO 객체입니다.
     * @return 입력된 인증 정보 DTO 객체를 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없거나 비밀번호가 일치하지 않을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.MEMBER_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    AuthDTO createAdminAuth(AuthDTO authDTO);
  
    /**
     * Trainer의 인증 정보를 생성하는 메서드입니다.
     *
     * @param Trainer의 username과 password를 담고 있는 authDTO 인증 정보 DTO 객체입니다.
     * @return 입력된 인증 정보 DTO 객체를 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없거나 비밀번호가 일치하지 않을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.MEMBER_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    AuthDTO createTrainerAuth(AuthDTO authDTO);
}
