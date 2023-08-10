package com.vincentdao.pimtoolback.domain.employee.exception;

public class EmptyVisaException extends EmployeeException {

    public EmptyVisaException() {
        super("Visa is null or empty");
    }
}
