package com.vincentdao.pimtoolback.domain.employee.exception;

public class EmptyFirstNameException extends EmployeeException {

    public EmptyFirstNameException() {
        super("First name is null or empty");
    }
}
