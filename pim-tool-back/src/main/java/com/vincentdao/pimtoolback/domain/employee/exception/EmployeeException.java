package com.vincentdao.pimtoolback.domain.employee.exception;

import com.vincentdao.pimtoolback.exception.PimToolBackException;

public abstract class EmployeeException extends PimToolBackException {

    public EmployeeException(String message) {
        super(message);
    }
}
