package com.backend.hyunfit.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* Business Exceptions */
    // 400 BAD REQUEST
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "유효하지 않은 입력값입니다."),
    TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "입력된 enum값이 유효하지 않습니다."),

    // 401 UNAUTHORIZED
    USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "비밀번호가 올바르지 않거나 존재하지 않는 사용자입니다."),

    // 403 FORBIDDEN

    // 404 NOT FOUND

    USERID_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 ID의 사용자를 찾을 수 없습니다."),
    USERSEQ_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 Sequence의 사용자를 찾을 수 없습니다."),
    URL_NOT_FOUND(HttpStatus.NOT_FOUND, "URL을 찾을 수 없습니다."),
    CM_CODE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 공통코드값입니다."),
    RESERVATION_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 예약 ID입니다."),
    ROUTINE_NOT_FOUND(HttpStatus.NOT_FOUND, "조건에 맞는 루틴을 찾을 수 없습니다."),
    // 405 Method Not Allowed
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "유효하지 않은 HTTP method입니다."),


    // 406 Not Acceptable

    // 500 INTERNAL SERVER ERROR
    DB_QUERY_UPDATE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Update 쿼리가 정상적으로 완료되지 않았습니다."),
    DB_QUERY_INSERT_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Insert 쿼리가 정상적으로 완료되지 않았습니다."),

    /* Spring Basic Exceptions */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String message;

}