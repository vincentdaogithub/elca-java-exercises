package com.vincentdao.pimtoolback.domain.group;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.validation.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Group implements SelfValidating {

    private final GroupId id;

    private EmployeeId groupLeaderId;

    @Override
    public void validate() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(groupLeaderId);
    }
}
