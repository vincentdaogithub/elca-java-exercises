package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class ModifyExistingProjectNumberException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Attempted to Modify Existing Project Number";
    }
}
