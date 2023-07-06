package vn.elca.training.controller.exception;

import vn.elca.training.custom_exception.AbstractCustomException;

public class InvalidUserRequestException extends AbstractCustomException {

    @Override
    public String getDetailedCause() {
        return "Invalid Request coming from User";
    }
}
