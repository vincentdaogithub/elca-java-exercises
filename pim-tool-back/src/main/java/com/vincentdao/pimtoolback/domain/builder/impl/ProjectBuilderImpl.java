package com.vincentdao.pimtoolback.domain.builder.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import com.vincentdao.pimtoolback.domain.builder.Builder;
import com.vincentdao.pimtoolback.domain.builder.ProjectBuilder;
import com.vincentdao.pimtoolback.domain.entity.Project;

public class ProjectBuilderImpl extends Builder<Project> implements ProjectBuilder {

    @Override
    public void setId(BigDecimal id) {
        this.objToBuild.setId(id);
    }

    @Override
    public void setGroupId(BigDecimal groupId) {
        this.objToBuild.setGroupId(groupId);
    }

    @Override
    public void setProjectNumber(Integer projectNumber) {
        this.objToBuild.setProjectNumber(projectNumber);
    }

    @Override
    public void setName(String name) {
        this.objToBuild.setName(name);
    }

    @Override
    public void setCustomer(String customer) {
        this.objToBuild.setCustomer(customer);
    }

    @Override
    public void setStatus(String status) {
        this.objToBuild.setStatus(status);
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        this.objToBuild.setStartDate(startDate);
    }

    @Override
    public void setEndDate(LocalDate endDate) {
        this.objToBuild.setEndDate(endDate);
    }

    @Override
    protected void reset() {
        this.objToBuild = new Project();
    }

    @Override
    public void setProjectEmployeeIds(Collection<BigDecimal> projectEmployeeIds) {
        this.objToBuild.setProjectEmployeeIds(projectEmployeeIds);
    }
}
