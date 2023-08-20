package com.vincentdao.pimtoolback.domain.employee;

import java.util.Objects;

public record EmployeeId(Long value) {

    public EmployeeId {
        if (Objects.requireNonNull(value, "Id must not be null") < 1L) {
            throw new IllegalArgumentException("Id must be positive");
        }
    }
}
