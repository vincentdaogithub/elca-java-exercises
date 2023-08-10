package com.vincentdao.pimtoolback.domain.project.exception;

public class EmptyCustomerNameException extends ProjectException {

    public EmptyCustomerNameException() {
        super("Customer name is null or empty");
    }
}
