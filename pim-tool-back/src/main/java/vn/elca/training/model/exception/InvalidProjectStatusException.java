package vn.elca.training.model.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class InvalidProjectStatusException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Project Status does not exist in predefined set of Statuses";
    }
}
