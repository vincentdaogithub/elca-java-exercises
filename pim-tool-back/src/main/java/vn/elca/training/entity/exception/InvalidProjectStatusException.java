package vn.elca.training.entity.exception;

import vn.elca.training.exception.AbstractCustomException;

public class InvalidProjectStatusException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Project Status does not exist in predefined set of Statuses";
    }
}
