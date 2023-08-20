package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.exception.ProjectEmployeeListContainsGroupLeaderException;
import com.vincentdao.pimtoolback.domain.validation.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Set;

@Getter
@AllArgsConstructor
public class Project implements SelfValidating {

    private final ProjectId id;

    @NonNull
    private ProjectGroup projectGroup;

    @NonNull
    private final ProjectNumber projectNumber;

    @NonNull
    private ProjectName projectName;

    @NonNull
    private ProjectCustomer projectCustomer;

    @NonNull
    private ProjectStatus projectStatus;

    @NonNull
    private ProjectDuration projectDuration;

    @NonNull
    private Set<EmployeeId> projectEmployees;

    @Override
    public void validate() {
        if (projectEmployees.contains(projectGroup.groupLeaderId())) {
            throw new ProjectEmployeeListContainsGroupLeaderException();
        }
    }
}
