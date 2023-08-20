package com.vincentdao.pimtoolback.domain.exception;

public class ProjectEmployeeListContainsGroupLeaderException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Project employee list has group leader";

    public ProjectEmployeeListContainsGroupLeaderException() {
        super(DEFAULT_MESSAGE);
    }
}
