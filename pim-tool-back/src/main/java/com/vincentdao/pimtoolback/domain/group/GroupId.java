package com.vincentdao.pimtoolback.domain.group;

import java.util.Objects;

public record GroupId(Long value) {

    public GroupId {
        if (Objects.requireNonNull(value, "Id must not be null") < 1L) {
            throw new IllegalArgumentException("Id must be positive");
        }
    }
}
