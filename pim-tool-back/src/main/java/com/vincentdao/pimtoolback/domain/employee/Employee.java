package com.vincentdao.pimtoolback.domain.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Employee {

    private final EmployeeId id;

    @NonNull
    private EmployeeVisa visa;

    @NonNull
    private EmployeeName name;

    @NonNull
    private EmployeeBirthDate birthDate;
}
