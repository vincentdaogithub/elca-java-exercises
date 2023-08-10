package com.vincentdao.pimtoolback.domain.project.exception;

public class InvalidCustomerNameException extends ProjectException {

    public InvalidCustomerNameException(int maxLength) {
        super(String.format("Customer name has trailing spaces or exceeds %d characters", maxLength));
    }
}
