package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class NoneOrMultipleProjectsUpdateException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "0 or multiple rows affected while Updating single Project";
    }
}
