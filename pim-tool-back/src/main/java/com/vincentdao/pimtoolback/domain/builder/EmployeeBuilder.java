package com.vincentdao.pimtoolback.domain.builder;

import java.math.BigDecimal;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.entity.Employee;

public interface EmployeeBuilder {

    void setId(BigDecimal id);

    void setVisa(String visa);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setBirthDate(Date birthDate);

    Employee build();
}
