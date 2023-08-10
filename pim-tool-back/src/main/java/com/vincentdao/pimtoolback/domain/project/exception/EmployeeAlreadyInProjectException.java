package com.vincentdao.pimtoolback.domain.project.exception;

import com.vincentdao.pimtoolback.domain.employee.Employee;

public class EmployeeAlreadyInProjectException extends ProjectException {

    public EmployeeAlreadyInProjectException(Employee employee) {
        super(String.format("Project already has employee: %s", employee.toString()));
    }
}
