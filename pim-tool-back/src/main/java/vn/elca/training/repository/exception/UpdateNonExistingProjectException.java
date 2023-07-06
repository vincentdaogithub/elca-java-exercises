package vn.elca.training.repository.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class UpdateNonExistingProjectException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Attempted to update Non Existing Project";
    }
}
