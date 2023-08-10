package com.vincentdao.pimtoolback.domain.project.exception;

public class ProjectNumberChangedDuringUpdateException extends ProjectException {

    public ProjectNumberChangedDuringUpdateException() {
        super("Project number is modified during update");
    }
}
