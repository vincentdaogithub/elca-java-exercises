package com.vincentdao.pimtoolback.domain.exception;

public abstract class DomainException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String customMessage;

    protected DomainException() {
        super();
        this.customMessage = setDefaultMessage();
    }

    protected DomainException(String message, Throwable cause) {
        super(cause);
        this.customMessage = (message == null || message.isBlank()) ? setDefaultMessage() : message;
    }

    protected DomainException(String message) {
        this.customMessage = (message == null || message.isBlank()) ? setDefaultMessage() : message;
    }

    protected abstract String setDefaultMessage();

    @Override
    public String getMessage() {
        return customMessage;
    }
}
