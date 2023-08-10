package com.vincentdao.pimtoolback.domain.employee.exception;

public class InvalidLastNameException extends EmployeeException {

    public InvalidLastNameException(int maxLength) {
        super(String.format("Last name has trailing space or exceeds %d characters", maxLength));
    }
}
