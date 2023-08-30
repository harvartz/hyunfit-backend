package com.backend.hyunfit.global.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String reason;
    private String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.reason = errorCode.name();
        this.message = errorCode.getMessage();
    }
    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
        return new ResponseEntity<>(
                new ErrorResponse(errorCode),
                errorCode.getStatus()
        );
    }
}