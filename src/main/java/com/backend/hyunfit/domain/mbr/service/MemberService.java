package com.backend.hyunfit.domain.mbr.service;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.global.exception.BusinessException;

public interface MemberService {
    /**
     * Member의 정보를 업데이트하는 메서드입니다.
     *
     * @param memberDTO Member의 정보를 업데이트합니다.
     * @throws BusinessException 입력된 사용자 ID에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    void updateOneMemberById(MemberDTO memberDTO);

    /**
     * Member의 정보를 조회하는 메서드입니다.
     *
     * @param mbrId Member의 ID 값 입니다.
     * @return 회원 정보를 MemberDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    MemberDTO selectOneMemberById(String mbrId);

    /**
     * Member의 전체 예약 정보를 조회하는 메서드입니다.
     *
     * @param mbrSeq,
     * @param offSet
     * @param limit Member의 Seq 값 입니다.
     * @return Member의 전체 예약 정보를 MemberDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    MemberDTO selectAllMemberPtBySeq(String mbrSeq, int offSet, int limit);

}
