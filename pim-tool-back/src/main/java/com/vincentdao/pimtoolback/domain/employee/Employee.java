package com.vincentdao.pimtoolback.domain.employee;

import com.vincentdao.pimtoolback.domain.validation.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Employee implements SelfValidating {

    private final EmployeeId id;

    private EmployeeVisa visa;

    private EmployeeName name;

    private EmployeeBirthDate birthDate;

    @Override
    public void validate() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(visa);
        Objects.requireNonNull(name);
        Objects.requireNonNull(birthDate);
    }
}
