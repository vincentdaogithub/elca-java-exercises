package vn.elca.training.repository.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class ModifyExistingProjectNumberException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Attempted to Modify Existing Project Number";
    }
}
