package com.backend.hyunfit.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public static BusinessException of(ErrorCode errorCode) {
        return new BusinessException(errorCode);
    }
    public static Supplier<BusinessException> supplierOf(ErrorCode errorCode) {
        return () -> BusinessException.of(errorCode);
    }
}
