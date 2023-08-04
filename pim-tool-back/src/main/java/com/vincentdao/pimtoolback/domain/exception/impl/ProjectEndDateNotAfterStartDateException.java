package com.vincentdao.pimtoolback.domain.exception.impl;

import com.vincentdao.pimtoolback.domain.exception.DomainException;

public class ProjectEndDateNotAfterStartDateException extends DomainException {

    private static final long serialVersionUID = 1L;

    public ProjectEndDateNotAfterStartDateException() {
        super();
    }

    public ProjectEndDateNotAfterStartDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectEndDateNotAfterStartDateException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        return "Project end date is not after the start date";
    }
}
