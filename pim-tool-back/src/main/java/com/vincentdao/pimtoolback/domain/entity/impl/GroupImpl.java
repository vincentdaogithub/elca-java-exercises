package com.vincentdao.pimtoolback.domain.entity.impl;

import java.math.BigDecimal;

import com.vincentdao.pimtoolback.domain.entity.Group;

public class GroupImpl implements Group {

    private BigDecimal id;
    private BigDecimal groupLeaderId;

    @Override
    public BigDecimal getId() {
        return id;
    }

    @Override
    public BigDecimal getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setGroupLeaderId(BigDecimal groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }
}
