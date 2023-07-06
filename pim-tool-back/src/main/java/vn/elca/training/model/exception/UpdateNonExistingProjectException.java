package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class UpdateNonExistingProjectException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Attempted to update Non Existing Project";
    }
}
