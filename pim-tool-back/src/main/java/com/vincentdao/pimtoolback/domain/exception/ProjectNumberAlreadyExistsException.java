package com.vincentdao.pimtoolback.domain.exception;

public class ProjectNumberAlreadyExistsException extends DomainException {

    private static final long serialVersionUID = 1L;

    public ProjectNumberAlreadyExistsException() {
        super();
    }

    public ProjectNumberAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNumberAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        return "Project number already exists";
    }
}
