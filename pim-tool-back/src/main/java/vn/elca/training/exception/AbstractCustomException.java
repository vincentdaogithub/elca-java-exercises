package vn.elca.training.exception;

public abstract class AbstractCustomException extends RuntimeException {

    public abstract String getDetailedCause();

    @Override
    public String getMessage() {
        return getDetailedCause();
    }
}
