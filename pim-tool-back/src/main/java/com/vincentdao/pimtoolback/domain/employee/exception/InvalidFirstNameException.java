package com.vincentdao.pimtoolback.domain.employee.exception;

public class InvalidFirstNameException extends EmployeeException {

    public InvalidFirstNameException(int maxLength) {
        super(String.format("First name has trailing space or exceeds %d characters", maxLength));
    }
}
