package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class DuplicateProjectNumberException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Project Number is Duplicated (must be Unique)";
    }
}
