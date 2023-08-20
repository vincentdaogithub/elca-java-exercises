package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.exception.InvalidProjectNumberException;

import java.util.Objects;

public record ProjectNumber(Integer value) {

    private static final int MAX_NUMBER = 9999;

    public ProjectNumber {
        Objects.requireNonNull(value, "Project number must not be null");
        if (value < 1 || value > MAX_NUMBER) {
            throw new InvalidProjectNumberException(MAX_NUMBER);
        }
    }
}
