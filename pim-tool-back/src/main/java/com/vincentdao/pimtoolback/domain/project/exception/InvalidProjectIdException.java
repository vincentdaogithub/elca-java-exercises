package com.vincentdao.pimtoolback.domain.project.exception;

public class InvalidProjectIdException extends ProjectException {

    public InvalidProjectIdException() {
        super("Id is null or below 1");
    }
}
