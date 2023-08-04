package com.vincentdao.pimtoolback.domain.builder.impl;

import java.math.BigDecimal;

import com.vincentdao.pimtoolback.domain.builder.Builder;
import com.vincentdao.pimtoolback.domain.builder.GroupBuilder;
import com.vincentdao.pimtoolback.domain.entity.Group;

public class GroupBuilderImpl extends Builder<Group> implements GroupBuilder {

    @Override
    public void setId(BigDecimal id) {
        this.objToBuild.setId(id);
    }

    @Override
    public void setGroupLeaderId(BigDecimal groupLeaderId) {
        this.objToBuild.setGroupLeaderId(groupLeaderId);
    }

    @Override
    protected void reset() {
        this.objToBuild = new Group();
    }
}
