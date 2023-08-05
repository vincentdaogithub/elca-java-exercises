package com.vincentdao.pimtoolback.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import com.vincentdao.pimtoolback.domain.status.ProjectStatuses;

public class Project extends Entity {

    private BigDecimal groupId;
    private Integer projectNumber;
    private String name;
    private String customer;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Collection<BigDecimal> projectEmployeeIds;

    public Project() {
        this.id = BigDecimal.ZERO;
        this.groupId = BigDecimal.ZERO;
        this.projectNumber = 0;
        this.name = "";
        this.customer = "";
        this.status = ProjectStatuses.NEW.getCode();
        this.startDate = LocalDate.now();
        this.endDate = null;
        this.projectEmployeeIds = Collections.emptyList();
    }

    public BigDecimal getGroupId() {
        return groupId;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public String getName() {
        return name;
    }

    public String getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Collection<BigDecimal> getProjectEmployeeIds() {
        return projectEmployeeIds;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setProjectEmployeeIds(Collection<BigDecimal> projectEmployeeIds) {
        this.projectEmployeeIds = projectEmployeeIds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + Objects.hash(customer, endDate, groupId, name, projectEmployeeIds, projectNumber, startDate, status);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        return Objects.equals(this.customer, other.customer) && Objects.equals(this.endDate, other.endDate)
                && Objects.equals(this.groupId, other.groupId) && Objects.equals(this.name, other.name)
                && Objects.equals(this.projectEmployeeIds, other.projectEmployeeIds)
                && Objects.equals(this.projectNumber, other.projectNumber)
                && Objects.equals(this.startDate, other.startDate) && Objects.equals(this.status, other.status);
    }
}
