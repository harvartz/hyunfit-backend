package com.backend.hyunfit.domain.adm.service;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import com.backend.hyunfit.global.exception.BusinessException;

public interface AdminService {
    /**
     * Admin의 정보를 조회하는 메서드입니다.
     *
     * @param admId Admin의 ID 값 입니다.
     * @return 회원 정보를 AdminDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 관리자 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    AdminDTO selectOneAdminByAdmId(String admId);
}
