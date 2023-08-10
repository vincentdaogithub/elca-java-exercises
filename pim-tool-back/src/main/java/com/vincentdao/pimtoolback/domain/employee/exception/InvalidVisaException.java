package com.vincentdao.pimtoolback.domain.employee.exception;

public class InvalidVisaException extends EmployeeException {

    public InvalidVisaException(int maxLength) {
        super(String.format("Invalid visa (must has length of %d and all uppercase)", maxLength));
    }
}
