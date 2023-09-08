package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.exception.ProjectEmployeeListContainsGroupLeaderException;
import com.vincentdao.pimtoolback.domain.validation.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Project implements SelfValidating {

    private final ProjectId id;

    private ProjectGroup projectGroup;

    private final ProjectNumber projectNumber;

    private ProjectName projectName;

    private ProjectCustomer projectCustomer;

    private ProjectStatus projectStatus;

    private ProjectDuration projectDuration;

    private List<EmployeeId> projectEmployees;

    @Override
    public void validate() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(projectGroup);
        Objects.requireNonNull(projectNumber);
        Objects.requireNonNull(projectName);
        Objects.requireNonNull(projectCustomer);
        Objects.requireNonNull(projectStatus);
        Objects.requireNonNull(projectDuration);
        Objects.requireNonNull(projectEmployees);

        if (projectEmployees.contains(projectGroup.groupLeaderId())) {
            throw new ProjectEmployeeListContainsGroupLeaderException();
        }
    }
}
