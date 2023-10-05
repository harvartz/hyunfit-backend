package com.backend.hyunfit.domain.mbr.service;

import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.mev.dto.MemberEventDTO;
import com.backend.hyunfit.domain.trnf.dto.TrainerFeedbackDTO;
import com.backend.hyunfit.global.dto.SearchDTO;
import com.backend.hyunfit.global.exception.BusinessException;

import java.util.List;


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
    MemberDTO selectOneMemberBymbrSeq(long mbrSeq);

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
    MemberDTO selectAllMemberPtBySeq(long mbrSeq, int page, String order, String ptReservationStatus);

    /**
     * Member의 전체 예약 정보를 조회하는 메서드입니다.
     *
     * @param mbrSeq Member의 Seq 값 입니다.
     * @param page
     * @param order
     * @param ptReservationStatus
     * @return Member의 전체 예약 정보를 MemberDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */

    MemberDTO selectPastPtCountBySeq(long mbrSeq);

    /**
     * Member의 전체 지난 예약의 총 갯수를 조회하는 메서드입니다.
     *
     * @param mbrSeq Member의 Seq 값 입니다.
     * @return Member의 전체 예약 정보를 MemberDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */

    MemberDTO selectOneMemberReportById(SearchDTO searchDTO);

    /**
     * Member가 받은 전체 피드백을 조회하는 메서드입니다.
     *
     * @param mbrSeq Member의 Seq 값.
     * @return 피드백 정보를 MemberDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */

     List<MemberEventDTO> selectAllMemberEventBySeq(SearchDTO searchDTO);

    /**
     * Member의 월 별 이벤트, 경험치를 조회하는 메서드입니다.
     *
     * @param mbrSeq Member의 Seq 값.
     * @return 피드백 정보를 MemberEventDTO 객체에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    MemberDTO selectAllMemberTrnfByMbrSeq(long mbrSeq);

    /**
     * Member가 받은 피드백 중 해당 월의 피드백을 조회하는 메서드입니다.
     *
     * @param mbrSeq Member의 Seq 값.
     * @param date 해당 월의 값.
     * @return 피드백을 String에 담아 반환합니다.
     * @throws BusinessException 입력된 사용자 이름에 해당하는 회원 정보가 없을 경우 발생하는 예외입니다.
     *                          이 예외는 ErrorCode.USERID_NOT_FOUND 에러 코드와 함께 발생합니다.
     */
    TrainerFeedbackDTO selectOneMemberTrnfByMbrSeq(long mbrSeq, String date);
}
