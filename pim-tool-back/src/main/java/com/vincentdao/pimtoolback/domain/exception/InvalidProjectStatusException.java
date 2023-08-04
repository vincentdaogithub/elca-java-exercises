package com.vincentdao.pimtoolback.domain.exception;

import com.vincentdao.pimtoolback.domain.status.ProjectStatuses;

public class InvalidProjectStatusException extends DomainException {

    private static final long serialVersionUID = 1L;

    public InvalidProjectStatusException() {
        super();
    }

    public InvalidProjectStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProjectStatusException(String message) {
        super(message);
    }

    @Override
    protected String setDefaultMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("Project status is invalid (");
        for (ProjectStatuses projectStatus : ProjectStatuses.values()) {
            builder.append(projectStatus.getCode());
            builder.append(": ");
            builder.append(projectStatus.toString());
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(')');
        return builder.toString();
    }
}
