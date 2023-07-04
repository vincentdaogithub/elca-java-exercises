package vn.elca.training.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectDto {

    private BigDecimal id;
    private Integer projectNumber;
    private String projectName;
    private String customer;
    private String groupLeaderVisa;
    private String status;
    private Date startDate;
    private Date endDate;

    public ProjectDto() { }

    public ProjectDto(BigDecimal id, Integer projectNumber, String projectName, String customer, String status,
                      Date startDate, Date endDate) {
        this.id = id;
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.customer = customer;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getGroupLeaderVisa() {
        return groupLeaderVisa;
    }

    public void setGroupLeaderVisa(String groupLeaderVisa) {
        this.groupLeaderVisa = groupLeaderVisa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
