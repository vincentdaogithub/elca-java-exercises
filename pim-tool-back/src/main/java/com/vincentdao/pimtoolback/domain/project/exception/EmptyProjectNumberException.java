package com.vincentdao.pimtoolback.domain.project.exception;

public class EmptyProjectNumberException extends ProjectException {

    public EmptyProjectNumberException() {
        super("Project number is null");
    }
}
