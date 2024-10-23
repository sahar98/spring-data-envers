package com.sajaya.backend.SJA.exception;

public enum ErrorType {

    CANNOT_EDIT_FROM_DATE_AFTER_PLAN_STARTED(1022, "Cannot change plan's fromDate after plan started.");
    private final int errorCode;
    private final String message;
    ErrorType(int errorCode) {
        this.errorCode = errorCode;
        this.message = null;
    }
    ErrorType(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }
    public static ErrorType valueOfCode(int errorCode) {
        for (ErrorType errorType : values()) {
            if (errorType.errorCode == errorCode)
                return errorType;
        }
        throw new IllegalArgumentException("Invalid ErrorCode.");
    }

}
