package com.vincentdao.pimtoolback.domain.project.exception;

public class ProjectNumberNotInRangeException extends ProjectException {

    public ProjectNumberNotInRangeException(int maxProjectNumber) {
        super(String.format("Project number not in [1, %d] range", maxProjectNumber));
    }
}
