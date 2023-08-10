package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.employee.exception.EmptyVisaException;
import com.vincentdao.pimtoolback.domain.employee.exception.InvalidVisaException;

public record Visa(String value) {

    private static final int MAX_VISA_LENGTH = 3;

    public Visa {
        if (value == null || value.isBlank()) {
            throw new EmptyVisaException();
        }
        if (value.trim().length() != MAX_VISA_LENGTH || !value.equals(value.toUpperCase())) {
            throw new InvalidVisaException(MAX_VISA_LENGTH);
        }
    }
}
