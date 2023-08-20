package com.vincentdao.pimtoolback.domain.group;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Group {

    private final GroupId id;

    @NonNull
    private EmployeeId groupLeaderId;
}
