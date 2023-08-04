package com.vincentdao.pimtoolback.domain.builder.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.builder.Builder;
import com.vincentdao.pimtoolback.domain.entity.impl.EmployeeImpl;

public class EmployeeBuilderImpl extends Builder<EmployeeImpl> {

    public void setId(BigDecimal id) {
        this.objToBuild.setId(id);
    }

    public void setVisa(String visa) {
        this.objToBuild.setVisa(visa);
    }

    public void setFirstName(String firstName) {
        this.objToBuild.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.objToBuild.setLastName(lastName);
    }

    public void setBirthDate(Date birthDate) {
        this.objToBuild.setBirthDate(birthDate);
    }

    @Override
    protected void reset() {
        this.objToBuild = new EmployeeImpl();
    }
}
