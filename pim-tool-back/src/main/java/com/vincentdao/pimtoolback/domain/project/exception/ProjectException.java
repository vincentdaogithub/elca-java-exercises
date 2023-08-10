package com.vincentdao.pimtoolback.domain.project.exception;

import com.vincentdao.pimtoolback.exception.PimToolBackException;

public abstract class ProjectException extends PimToolBackException {

    public ProjectException(String message) {
        super(message);
    }
}
