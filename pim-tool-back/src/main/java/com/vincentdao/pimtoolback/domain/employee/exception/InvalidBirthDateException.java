package com.vincentdao.pimtoolback.domain.employee.exception;

public class InvalidBirthDateException extends EmployeeException {

    public InvalidBirthDateException(int minimumAge) {
        super(String.format("Birth date is in the future or not %d years apart from now", minimumAge));
    }
}
