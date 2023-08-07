package com.vincentdao.pimtoolback.application.exception;

public abstract class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String customMessage;

    protected ApplicationException() {
        super();
        this.customMessage = setDefaultMessage();
    }

    protected ApplicationException(String message, Throwable cause) {
        super(cause);
        this.customMessage = (message == null || message.isBlank()) ? setDefaultMessage() : message;
    }

    protected ApplicationException(String message) {
        this.customMessage = (message == null || message.isBlank()) ? setDefaultMessage() : message;
    }

    protected abstract String setDefaultMessage();

    @Override
    public String getMessage() {
        return customMessage;
    }
}
