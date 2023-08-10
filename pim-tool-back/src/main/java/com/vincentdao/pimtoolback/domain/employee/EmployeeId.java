package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.employee.exception.InvalidEmployeeIdException;

public record EmployeeId(Long value) {

    public EmployeeId {
        if (value == null || value < 1) {
            throw new InvalidEmployeeIdException();
        }
    }
}
