package com.vincentdao.pimtoolback.domain.entity;

import java.util.Date;
import java.util.Objects;

public class Employee extends Entity {

    private String visa;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public String getVisa() {
        return visa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(birthDate, firstName, lastName, visa);
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
        Employee other = (Employee) obj;
        return Objects.equals(this.birthDate, other.birthDate) && Objects.equals(this.firstName, other.firstName)
                && Objects.equals(this.lastName, other.lastName) && Objects.equals(this.visa, other.visa);
    }
}
