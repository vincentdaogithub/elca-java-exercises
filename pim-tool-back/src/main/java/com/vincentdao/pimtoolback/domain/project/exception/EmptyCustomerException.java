package com.vincentdao.pimtoolback.domain.project.exception;

public class EmptyCustomerException extends ProjectException {

    public EmptyCustomerException() {
        super("Customer is null");
    }
}
