package com.vincentdao.pimtoolback.domain.employee.exception;

public class InvalidEmployeeIdException extends EmployeeException {

    public InvalidEmployeeIdException() {
        super("Id is null or below 1");
    }
}
