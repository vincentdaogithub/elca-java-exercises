package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.exception.EmployeeAgeNotAboveRequiredMinimumException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public record EmployeeBirthDate(LocalDate value) {

    public static final int MIN_AGE = 18;

    public EmployeeBirthDate {
        Objects.requireNonNull(value, "Birth date should not be null");
        if (Period.between(value, LocalDate.now()).getYears() < MIN_AGE) {
            throw new EmployeeAgeNotAboveRequiredMinimumException(MIN_AGE);
        }
    }
}
