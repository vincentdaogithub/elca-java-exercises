package com.vincentdao.pimtoolback.domain.builder;

import java.math.BigDecimal;

import com.vincentdao.pimtoolback.domain.entity.Group;

public interface GroupBuilder {

    void setId(BigDecimal id);

    void setGroupLeaderId(BigDecimal groupLeaderId);

    Group build();
}
