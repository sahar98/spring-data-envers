package com.sajaya.backend.SJA.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class SJAException extends RuntimeException{
    private final HttpStatus status;

    public SJAException() {
        this.status = BAD_REQUEST;
    }
    public SJAException(String message) {
        super(message);
        this.status = BAD_REQUEST;
    }
    public SJAException(HttpStatus status) {
        this.status = status;
    }
    public SJAException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return this.status;
    }
}
