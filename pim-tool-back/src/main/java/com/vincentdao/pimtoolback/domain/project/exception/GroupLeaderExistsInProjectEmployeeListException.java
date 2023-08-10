package com.vincentdao.pimtoolback.domain.project.exception;

import com.vincentdao.pimtoolback.domain.employee.Employee;

public class GroupLeaderExistsInProjectEmployeeListException extends ProjectException {

    public GroupLeaderExistsInProjectEmployeeListException(Employee groupLeader) {
        super(String.format("Group leader %s exists in project employee list", groupLeader.toString()));
    }
}
