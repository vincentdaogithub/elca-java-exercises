package vn.elca.training.model.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class DuplicateEmployeeVisaException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Employee Visa is Duplicated (must be Unique)";
    }
}
