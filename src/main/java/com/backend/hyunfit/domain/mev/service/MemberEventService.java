package com.backend.hyunfit.domain.mev.service;

import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.global.exception.BusinessException;

public interface MemberEventService {
    /**
     * Member의 Event정보를 생성하는 메서드입니다.
     *
     * @param memberEventDTO Member의 Event정보를 생성합니다.
     * @throws BusinessException 예약이 생성되지 않을 때 발생하는 예외입니다.
     *      *                    이 예외는ErrorCode.DB_QUERY_INSERT_EXCEPTION 에러 코드와 함께 발생합니다.
     */
    void createEventBymbrSeq(MemberEventDTO memberEventDTO);
}
