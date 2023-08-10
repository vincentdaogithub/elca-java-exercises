package com.vincentdao.pimtoolback.domain.project.exception;

public class InvalidProjectNameException extends ProjectException {

    public InvalidProjectNameException(int maxLength) {
        super(String.format("Project name has trailing spaces or exceeds %d characters", maxLength));
    }
}
