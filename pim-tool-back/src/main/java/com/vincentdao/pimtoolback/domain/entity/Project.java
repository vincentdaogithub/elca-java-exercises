package com.vincentdao.pimtoolback.domain.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public interface Project {

    BigDecimal getId();

    Integer getProjectNumber();

    String getName();

    BigDecimal getGroupId();

    Collection<BigDecimal> getProjectEmployeeIds();

    String getCustomer();

    String getStatus();

    Date getStartDate();

    Date getEndDate();
}
