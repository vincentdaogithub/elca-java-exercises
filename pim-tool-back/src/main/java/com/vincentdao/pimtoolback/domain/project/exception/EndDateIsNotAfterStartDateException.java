package com.vincentdao.pimtoolback.domain.project.exception;

public class EndDateIsNotAfterStartDateException extends ProjectException {

    public EndDateIsNotAfterStartDateException() {
        super("End date is before or the same as start date");
    }
}
