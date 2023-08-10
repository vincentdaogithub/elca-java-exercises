package com.vincentdao.pimtoolback.domain.group.exception;

public class EmptyGroupLeaderException extends GroupException {

    public EmptyGroupLeaderException() {
        super("Group leader is null");
    }
}
