package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.group.GroupId;

import java.util.Objects;

public record ProjectGroup(GroupId id, EmployeeId groupLeaderId) {

    public ProjectGroup {
        Objects.requireNonNull(id, "Group id must not be null");
        Objects.requireNonNull(groupLeaderId, "Group leader id must not be null");
    }
}
