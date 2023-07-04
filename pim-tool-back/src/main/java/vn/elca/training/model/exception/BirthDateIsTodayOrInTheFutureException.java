package vn.elca.training.model.exception;

import vn.elca.training.exception.AbstractCustomException;

public class BirthDateIsTodayOrInTheFutureException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Birth Date is Today or in the Future";
    }
}
