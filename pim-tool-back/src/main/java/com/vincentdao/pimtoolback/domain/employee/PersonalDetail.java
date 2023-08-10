package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.employee.exception.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record PersonalDetail(String firstName, String lastName, LocalDate birthDate) {

    private static final int MAX_NAME_LENGTH = 50;
    private static final int MINIMUM_AGE = 18;

    public PersonalDetail {
        if (firstName == null || firstName.isBlank()) {
            throw new EmptyFirstNameException();
        }
        if (firstName.trim().length() != firstName.length() || firstName.length() > MAX_NAME_LENGTH) {
            throw new InvalidFirstNameException(MAX_NAME_LENGTH);
        }

        if (lastName == null || lastName.isBlank()) {
            throw new EmptyLastNameException();
        }
        if (lastName.trim().length() != lastName.length() || lastName.length() > MAX_NAME_LENGTH) {
            throw new InvalidLastNameException(MAX_NAME_LENGTH);
        }

        if (birthDate == null) {
            throw new EmptyBirthDateException();
        }
        if (ChronoUnit.YEARS.between(birthDate, LocalDate.now()) < MINIMUM_AGE) {
            throw new InvalidBirthDateException(MINIMUM_AGE);
        }
    }
}
