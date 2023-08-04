package com.vincentdao.pimtoolback.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public interface Employee {

    BigDecimal getId();

    String getVisa();

    String getFirstName();

    String getLastName();

    Date getBirthDate();

    String getFullName();
}
