package com.vincentdao.pimtoolback.domain.exception;

public class InvalidProjectNumberException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Project number must be positive and below %d";

    public InvalidProjectNumberException(int maxNumber) {
        super(String.format(DEFAULT_MESSAGE, maxNumber));
    }
}
