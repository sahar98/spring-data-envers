package com.sajaya.backend.SJA.exception;

import org.springframework.http.HttpStatus;

public class SJAResponseException extends SJAException {
    private final ErrorType errorType;
    public SJAResponseException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SJAResponseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
    public SJAResponseException(ErrorType errorType, HttpStatus status) {
        super(status, errorType.getMessage());
        this.errorType = errorType;
    }

    public SJAResponseException(ErrorType errorType, HttpStatus status, String message) {
        super(status, message);
        this.errorType = errorType;
    }

    public int getErrorCode() {
        return errorType.getErrorCode();
    }
}
