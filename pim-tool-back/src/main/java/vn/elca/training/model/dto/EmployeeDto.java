package vn.elca.training.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDto {

    private BigDecimal id;
    private String visa;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public EmployeeDto() { }

    public EmployeeDto(BigDecimal id, String visa, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.visa = visa;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
