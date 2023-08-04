package com.vincentdao.pimtoolback.domain.entity.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.entity.Employee;

public class EmployeeImpl implements Employee {

    private BigDecimal id;
    private String visa;
    private String firstName;
    private String lastName;
    private Date birthDate;

    @Override
    public BigDecimal getId() {
        return id;
    }

    @Override
    public String getVisa() {
        return visa;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
