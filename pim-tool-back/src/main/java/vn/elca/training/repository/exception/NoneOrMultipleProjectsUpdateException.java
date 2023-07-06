package vn.elca.training.repository.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class NoneOrMultipleProjectsUpdateException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "0 or multiple rows affected while Updating single Project";
    }
}
