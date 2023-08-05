package com.vincentdao.pimtoolback.domain.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import com.vincentdao.pimtoolback.domain.entity.Project;

public interface ProjectBuilder {

    void setId(BigDecimal id);

    void setGroupId(BigDecimal groupId);

    void setProjectNumber(Integer projectNumber);

    void setName(String name);

    void setCustomer(String customer);

    void setStatus(String status);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);

    void setProjectEmployeeIds(Collection<BigDecimal> projectEmployeeIds);

    Project build();
}
