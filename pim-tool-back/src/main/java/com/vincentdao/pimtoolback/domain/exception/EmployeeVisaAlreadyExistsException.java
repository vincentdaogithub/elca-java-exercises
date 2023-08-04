package com.vincentdao.pimtoolback.domain.exception;

public class EmployeeVisaAlreadyExistsException extends DomainException {

    private static final long serialVersionUID = 1L;

    public EmployeeVisaAlreadyExistsException() {
        super();
    }

    public EmployeeVisaAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeVisaAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        return "Employee visa already exists";
    }
}
