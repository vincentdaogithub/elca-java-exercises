package com.vincentdao.pimtoolback.domain.entity.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.entity.Project;

public class ProjectImpl implements Project {

    private BigDecimal id;
    private Integer projectNumber;
    private String name;
    private BigDecimal groupId;
    private Collection<BigDecimal> projectEmployeeIds;
    private String customer;
    private String status;
    private Date startDate;
    private Date endDate;

    @Override
    public BigDecimal getId() {
        return id;
    }

    @Override
    public Integer getProjectNumber() {
        return projectNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getGroupId() {
        return groupId;
    }

    @Override
    public Collection<BigDecimal> getProjectEmployeeIds() {
        return projectEmployeeIds;
    }

    @Override
    public String getCustomer() {
        return customer;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public void setProjectEmployeeIds(Collection<BigDecimal> projectEmployeeIds) {
        this.projectEmployeeIds = projectEmployeeIds == null ? Collections.emptyList() : projectEmployeeIds;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
