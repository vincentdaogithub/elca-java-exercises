package vn.elca.training.model.dto;

import vn.elca.training.model.constant_value.ProjectStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProjectUpdateDto {

    private Integer projectNumber;
    private String projectName;
    private String customer;
    private BigDecimal groupId;
    private List<BigDecimal> members;
    private ProjectStatus status;
    private Date startDate;
    private Date endDate;
    private Long version;

    public ProjectUpdateDto() { }

    public ProjectUpdateDto(Integer projectNumber, String projectName, String customer, BigDecimal groupId,
                            List<BigDecimal> members, ProjectStatus status, Date startDate, Date endDate) {
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.customer = customer;
        this.groupId = groupId;
        this.members = members;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ProjectUpdateDto(Integer projectNumber, String projectName, String customer, BigDecimal groupId,
                            List<BigDecimal> members, ProjectStatus status, Date startDate, Date endDate, Long version) {
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.customer = customer;
        this.groupId = groupId;
        this.members = members;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.version = version;
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

    public BigDecimal getGroupId() {
        return groupId;
    }

    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    public List<BigDecimal> getMembers() {
        return members;
    }

    public void setMembers(List<BigDecimal> members) {
        this.members = members;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
