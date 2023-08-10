package com.vincentdao.pimtoolback.domain.employee.exception;

public class EmptyBirthDateException extends EmployeeException {

    public EmptyBirthDateException() {
        super("Birth date is null");
    }
}
