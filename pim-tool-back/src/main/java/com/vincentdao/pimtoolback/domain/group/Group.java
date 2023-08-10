package com.vincentdao.pimtoolback.domain.group;

import com.vincentdao.pimtoolback.domain.employee.Employee;
import lombok.Getter;

@Getter
public class Group {

    private final GroupId id;
    private final Employee groupLeader;

    private Group(GroupId id, Employee groupLeader) {
        this.id = id;
        this.groupLeader = groupLeader;
    }

    public static Group createNew(GroupId id, Employee groupLeader) {
        if (id == null || groupLeader == null) {
            throw new IllegalArgumentException("Null arguments");
        }
        return new Group(id, groupLeader);
    }
}
