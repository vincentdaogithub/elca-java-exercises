package vn.elca.training.repository.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class NoProjectRemoveException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "0 row affected while Removing Project(s)";
    }
}
