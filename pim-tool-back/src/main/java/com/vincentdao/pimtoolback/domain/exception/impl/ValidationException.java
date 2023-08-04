package com.vincentdao.pimtoolback.domain.exception.impl;

import com.vincentdao.pimtoolback.domain.exception.DomainException;

/**
 * <p>
 * It is important to implement custom message here, since all the validation
 * errors (i.e. out of range, null, etc.) is used here.
 */
public class ValidationException extends DomainException {

    private static final long serialVersionUID = 1L;

    public ValidationException() {
        super();
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        return "Validation error";
    }
}
