package com.vincentdao.pimtoolback.domain.exception;

public class EmployeeAgeNotAboveRequiredMinimumException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Birth date is not %d years apart til now";

    public EmployeeAgeNotAboveRequiredMinimumException(int minimumAge) {
        super(String.format(DEFAULT_MESSAGE, minimumAge));
    }
}
