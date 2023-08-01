package com.hei.project2p1.model.exceptions;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(ExceptionType.CLIENT_EXCEPTION, message);
    }
}