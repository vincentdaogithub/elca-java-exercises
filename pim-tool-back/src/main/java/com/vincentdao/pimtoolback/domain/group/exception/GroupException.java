package com.vincentdao.pimtoolback.domain.group.exception;

import com.vincentdao.pimtoolback.exception.PimToolBackException;

public abstract class GroupException extends PimToolBackException {

    public GroupException(String message) {
        super(message);
    }
}
