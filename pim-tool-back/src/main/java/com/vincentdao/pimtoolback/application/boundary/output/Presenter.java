package com.vincentdao.pimtoolback.application.boundary.output;

import com.vincentdao.pimtoolback.application.model.response.ResponseModel;

public abstract class Presenter<T> {

    public abstract ResponseModel<T> prepareSuccessView(T data);

    public abstract ResponseModel<?> prepareFailView(String message);

    public ResponseModel<?> prepareFailView(Throwable cause) {
        return prepareFailView(cause.getMessage());
    }
}
