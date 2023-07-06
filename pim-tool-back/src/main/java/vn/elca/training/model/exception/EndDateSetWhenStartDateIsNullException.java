package vn.elca.training.model.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class EndDateSetWhenStartDateIsNullException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "End Date of the Project is set when the Start Date is Null";
    }
}
