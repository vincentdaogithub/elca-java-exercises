package com.vincentdao.pimtoolback.domain.builder.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.builder.Builder;
import com.vincentdao.pimtoolback.domain.builder.EmployeeBuilder;
import com.vincentdao.pimtoolback.domain.entity.Employee;

public class EmployeeBuilderImpl extends Builder<Employee> implements EmployeeBuilder {

    @Override
    public void setId(BigDecimal id) {
        this.objToBuild.setId(id);
    }

    @Override
    public void setVisa(String visa) {
        this.objToBuild.setVisa(visa);
    }

    @Override
    public void setFirstName(String firstName) {
        this.objToBuild.setFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.objToBuild.setLastName(lastName);
    }

    @Override
    public void setBirthDate(Date birthDate) {
        this.objToBuild.setBirthDate(birthDate);
    }

    @Override
    protected void reset() {
        this.objToBuild = new Employee();
    }
}
