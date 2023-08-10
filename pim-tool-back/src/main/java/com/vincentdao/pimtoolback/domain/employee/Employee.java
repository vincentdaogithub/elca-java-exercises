package com.vincentdao.pimtoolback.domain.employee;

import lombok.Getter;

@Getter
public class Employee {

    private final EmployeeId id;
    private final Visa visa;
    private final PersonalDetail personalDetail;

    private Employee(EmployeeId id, Visa visa, PersonalDetail personalDetail) {
        this.id = id;
        this.visa = visa;
        this.personalDetail = personalDetail;
    }

    public static Employee createNew(EmployeeId id, Visa visa, PersonalDetail personalDetail) {
        if (id == null || visa == null || personalDetail == null) {
            throw new IllegalArgumentException("Null arguments");
        }
        return new Employee(id, visa, personalDetail);
    }
}
