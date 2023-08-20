package com.vincentdao.pimtoolback.domain.project;

import java.util.Objects;

public record ProjectId(Long value) {

    public ProjectId {
        if (Objects.requireNonNull(value, "Id must not be null") < 1L) {
            throw new IllegalArgumentException("Id must be positive");
        }
    }
}
