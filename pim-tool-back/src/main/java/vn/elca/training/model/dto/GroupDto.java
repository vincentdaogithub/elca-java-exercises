package vn.elca.training.model.dto;

import java.math.BigDecimal;

public class GroupDto {

    private BigDecimal id;
    private String groupLeaderVisa;

    public GroupDto() { }

    public GroupDto(BigDecimal id, String groupLeaderVisa) {
        this.id = id;
        this.groupLeaderVisa = groupLeaderVisa;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getGroupLeaderVisa() {
        return groupLeaderVisa;
    }

    public void setGroupLeaderVisa(String groupLeaderVisa) {
        this.groupLeaderVisa = groupLeaderVisa;
    }
}
