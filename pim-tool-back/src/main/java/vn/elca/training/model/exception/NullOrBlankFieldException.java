package vn.elca.training.model.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class NullOrBlankFieldException extends AbstractCustomException {

    private final String fieldName;

    public NullOrBlankFieldException(String fieldName) {
        super();
        this.fieldName = fieldName;
    }

    @Override
    public String getDetailedCause() {
        return String.format("%s is Null or Blank", fieldName);
    }
}
