package vn.elca.training.custom_exception;

public abstract class AbstractCustomException extends RuntimeException {

    public abstract String getDetailedCause();

    @Override
    public String getMessage() {
        return getDetailedCause();
    }
}
