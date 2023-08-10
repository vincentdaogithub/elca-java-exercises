package com.vincentdao.pimtoolback.domain.project.exception;

public class EmptyStartDateException extends ProjectException {

    public EmptyStartDateException() {
        super("Start date is null");
    }
}
