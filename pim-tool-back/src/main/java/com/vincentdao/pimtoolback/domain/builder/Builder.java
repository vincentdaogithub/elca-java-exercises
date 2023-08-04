package com.vincentdao.pimtoolback.domain.builder;

public abstract class Builder<T> {

    protected T objToBuild;

    protected Builder() {
        this.reset();
    }

    protected abstract void reset();

    public T build() {
        T builtObj = objToBuild;
        this.reset();
        return builtObj;
    }
}
