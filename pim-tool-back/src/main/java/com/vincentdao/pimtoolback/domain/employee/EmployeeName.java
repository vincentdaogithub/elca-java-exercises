package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.util.CustomStringUtils;
import org.apache.commons.lang3.StringUtils;

public record EmployeeName(String firstName, String lastName) {

    private static final int MAX_LENGTH = 50;

    public EmployeeName {
        if (StringUtils.isBlank(firstName) || CustomStringUtils.hasTrailingSpaces(firstName)) {
            throw new IllegalArgumentException("First name should not be null, empty, or has trailing spaces");
        }
        if (firstName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("First name must not exceed %d characters", MAX_LENGTH));
        }
        if (StringUtils.isBlank(lastName) || CustomStringUtils.hasTrailingSpaces(lastName)) {
            throw new IllegalArgumentException("Last name should not be null, empty, or has trailing spaces");
        }
        if (lastName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("Last name must not exceed %d characters", MAX_LENGTH));
        }
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
