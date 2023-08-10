package com.vincentdao.pimtoolback.domain.project.exception;

public class EmptyProjectNameException extends ProjectException {

    public EmptyProjectNameException() {
        super("Project name is null or empty");
    }
}
