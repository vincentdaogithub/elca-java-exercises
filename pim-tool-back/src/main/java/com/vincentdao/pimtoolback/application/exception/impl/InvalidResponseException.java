package com.vincentdao.pimtoolback.application.exception.impl;

import com.vincentdao.pimtoolback.application.exception.ApplicationException;

public class InvalidResponseException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public InvalidResponseException() {
        super();
    }

    public InvalidResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidResponseException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        return "Invalid response";
    }
}
