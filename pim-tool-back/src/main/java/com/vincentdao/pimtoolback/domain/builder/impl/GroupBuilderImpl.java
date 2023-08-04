package com.vincentdao.pimtoolback.domain.builder.impl;

import java.math.BigDecimal;

import com.vincentdao.pimtoolback.domain.builder.Builder;
import com.vincentdao.pimtoolback.domain.entity.impl.GroupImpl;

public class GroupBuilderImpl extends Builder<GroupImpl> {

    public void setId(BigDecimal id) {
        this.objToBuild.setId(id);
    }

    public void setGroupLeaderId(BigDecimal groupLeaderId) {
        this.objToBuild.setGroupLeaderId(groupLeaderId);
    }

    @Override
    protected void reset() {
        this.objToBuild = new GroupImpl();
    }
}
