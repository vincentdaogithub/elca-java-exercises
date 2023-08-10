package com.vincentdao.pimtoolback.domain.employee.exception;

public class EmptyLastNameException extends EmployeeException {

    public EmptyLastNameException() {
        super("Last name is null or empty");
    }
}
