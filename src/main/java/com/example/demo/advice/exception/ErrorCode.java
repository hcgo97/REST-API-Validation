package com.example.demo.advice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE("E400", "Invalid Input Value"),
    METHOD_NOT_ALLOWED("E405", "Invalid Input Value"),
    INTERNAL_SERVER_ERROR("E500", "Server Error"),
    HANDLE_ACCESS_DENIED("E403", "Access is Denied"),
    NOT_FOUND("E404", "No handler found for your request");


    private String code;
    private final String message;


    ErrorCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return this.message;
    }

}