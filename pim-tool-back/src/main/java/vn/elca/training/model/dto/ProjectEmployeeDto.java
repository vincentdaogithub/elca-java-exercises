package vn.elca.training.model.dto;

import java.math.BigDecimal;

public class ProjectEmployeeDto {

    private BigDecimal id;
    private Integer projectNumber;
    private String employeeVisa;

    public ProjectEmployeeDto() {
    }

    public ProjectEmployeeDto(BigDecimal id, Integer projectNumber, String employeeVisa) {
        this.id = id;
        this.projectNumber = projectNumber;
        this.employeeVisa = employeeVisa;
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

    public String getEmployeeVisa() {
        return employeeVisa;
    }

    public void setEmployeeVisa(String employeeVisa) {
        this.employeeVisa = employeeVisa;
    }
}
