package com.vincentdao.pimtoolback.domain.exception;

public class EndDateIsNotBeforeStartDateException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "End date is not before start date";

    public EndDateIsNotBeforeStartDateException() {
        super(DEFAULT_MESSAGE);
    }
}
