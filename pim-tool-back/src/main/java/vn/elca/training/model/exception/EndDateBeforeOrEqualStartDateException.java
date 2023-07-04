package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class EndDateBeforeOrEqualStartDateException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "End Date of the Project happens before the Start Date";
    }
}