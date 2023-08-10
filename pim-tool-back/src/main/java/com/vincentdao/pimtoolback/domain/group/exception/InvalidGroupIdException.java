package com.vincentdao.pimtoolback.domain.group.exception;

public class InvalidGroupIdException extends GroupException {

    public InvalidGroupIdException() {
        super("Id is null or below 1");
    }
}
