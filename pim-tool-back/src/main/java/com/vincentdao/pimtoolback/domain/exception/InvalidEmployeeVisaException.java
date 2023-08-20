package com.vincentdao.pimtoolback.domain.exception;

public class InvalidEmployeeVisaException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Visa should be %d characters long and all in uppercase";

    public InvalidEmployeeVisaException(int visaLength) {
        super(String.format(DEFAULT_MESSAGE, visaLength));
    }
}
