package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.exception.InvalidEmployeeVisaException;
import com.vincentdao.pimtoolback.domain.util.CustomStringUtils;
import org.apache.commons.lang3.StringUtils;

public record EmployeeVisa(String value) {

    private static final int MAX_LENGTH = 3;

    public EmployeeVisa {
        if (StringUtils.isBlank(value) || CustomStringUtils.hasTrailingSpaces(value)) {
            throw new IllegalArgumentException("Visa should not be null, empty, or has trailing spaces");
        }
        if (value.length() != MAX_LENGTH || !StringUtils.isAllUpperCase(value)) {
            throw new InvalidEmployeeVisaException(MAX_LENGTH);
        }
    }
}
