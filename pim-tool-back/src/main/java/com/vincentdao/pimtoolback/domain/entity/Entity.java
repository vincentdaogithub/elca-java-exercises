package com.vincentdao.pimtoolback.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Entity {

    protected BigDecimal id;

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entity other = (Entity) obj;
        return Objects.equals(this.id, other.id);
    }
}
