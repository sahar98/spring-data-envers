package com.sajaya.backend.SJA.exception;

import org.springframework.http.HttpStatus;

public class SJAConflictException extends SJAResponseException {
    private final Object conflict;

    public SJAConflictException(ErrorType errorType, Object conflict) {
        super(errorType, HttpStatus.CONFLICT);
        this.conflict = conflict;
    }

    public Object getConflict() {
        return conflict;
    }
}
