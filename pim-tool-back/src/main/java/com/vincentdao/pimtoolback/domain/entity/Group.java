package com.vincentdao.pimtoolback.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Group extends Entity {

    private BigDecimal groupLeaderId;

    public BigDecimal getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(BigDecimal groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(groupLeaderId);
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
        Group other = (Group) obj;
        return Objects.equals(this.groupLeaderId, other.groupLeaderId);
    }
}
