package com.vincentdao.pimtoolback.domain.builder;

import com.vincentdao.pimtoolback.domain.entity.Entity;

public abstract class Builder<T extends Entity> {

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
