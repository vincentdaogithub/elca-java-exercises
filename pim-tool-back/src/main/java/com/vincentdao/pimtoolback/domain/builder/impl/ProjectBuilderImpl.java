package com.vincentdao.pimtoolback.domain.builder.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.builder.Builder;
import com.vincentdao.pimtoolback.domain.entity.impl.ProjectImpl;

public class ProjectBuilderImpl extends Builder<ProjectImpl> {

    public void setId(BigDecimal id) {
        this.objToBuild.setId(id);
    }

    public void setProjectNumber(Integer projectNumber) {
        this.objToBuild.setProjectNumber(projectNumber);
    }

    public void setName(String name) {
        this.objToBuild.setName(name);
    }

    public void setGroupId(BigDecimal groupId) {
        this.objToBuild.setGroupId(groupId);
    }

    public void setProjectEmployeeIds(Collection<BigDecimal> projectEmployeeIds) {
        this.objToBuild.setProjectEmployeeIds(projectEmployeeIds);
    }

    public void setCustomer(String customer) {
        this.objToBuild.setCustomer(customer);
    }

    public void setStatus(String status) {
        this.objToBuild.setStatus(status);
    }

    public void setStartDate(Date startDate) {
        this.objToBuild.setStartDate(startDate);
    }

    public void setEndDate(Date endDate) {
        this.objToBuild.setEndDate(endDate);
    }

    @Override
    protected void reset() {
        this.objToBuild = new ProjectImpl();
    }
}
