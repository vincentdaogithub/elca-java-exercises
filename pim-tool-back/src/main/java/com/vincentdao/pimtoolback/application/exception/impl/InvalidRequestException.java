package com.vincentdao.pimtoolback.application.exception.impl;

import com.vincentdao.pimtoolback.application.exception.ApplicationException;

public class InvalidRequestException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public InvalidRequestException() {
        super();
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        return "Invalid request";
    }
}
