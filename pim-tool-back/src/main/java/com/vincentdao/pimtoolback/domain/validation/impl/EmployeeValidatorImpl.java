package com.vincentdao.pimtoolback.domain.validation.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.entity.Employee;
import com.vincentdao.pimtoolback.domain.exception.ValidationException;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;

public class EmployeeValidatorImpl implements DomainValidator<Employee> {

    @Override
    public void validate(Employee entity) {
        validateId(entity.getId());
        validateVisa(entity.getVisa());
        validateFirstName(entity.getFirstName());
        validateLastName(entity.getLastName());
        validateBirthDate(entity.getBirthDate());
    }

    private void validateId(BigDecimal id) {
        if (id == null) {
            throw new ValidationException("Id is null");
        }
        if (id.scale() > 0) {
            throw new ValidationException("Id is not integer");
        }
        if (id.compareTo(BigDecimal.ZERO) < 0 || id.precision() > 19) {
            throw new ValidationException("Id is below 0 or above 19 digits");
        }
    }

    private void validateVisa(String visa) {
        if (visa == null || visa.isBlank()) {
            throw new ValidationException("Visa is null or empty");
        }
        if (visa.length() > 3) {
            throw new ValidationException("Visa length exceeds length of 3 characters");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new ValidationException("First name is null or empty");
        }
        if (firstName.length() > 50) {
            throw new ValidationException("First name length exceeds length of 50 characters");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new ValidationException("Last name is null or empty");
        }
        if (lastName.length() > 50) {
            throw new ValidationException("Last name length exceeds length of 50 characters");
        }
    }

    private void validateBirthDate(Date birthDate) {
        if (birthDate == null) {
            throw new ValidationException("Birth date is null");
        }
        if (birthDate.compareTo(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())) >= 0) {
            throw new ValidationException("Birth date is today or in the future");
        }
    }
}
