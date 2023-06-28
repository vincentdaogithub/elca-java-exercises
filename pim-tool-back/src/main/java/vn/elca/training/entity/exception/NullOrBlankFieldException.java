package vn.elca.training.entity.exception;

import vn.elca.training.exception.AbstractCustomException;

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
