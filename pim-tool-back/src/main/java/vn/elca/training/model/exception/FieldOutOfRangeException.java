package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class FieldOutOfRangeException extends AbstractCustomException {

    private final String fieldName;

    public FieldOutOfRangeException(String fieldName) {
        super();
        this.fieldName = fieldName;
    }

    @Override
    public String getDetailedCause() {
        return String.format("%s is Out of Range", fieldName);
    }
}
