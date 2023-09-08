/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.gateway;

import com.vincentdao.pimtoolback.application.project.gateway.ViewProjectsWithFiltersPaginatedGateway;
import com.vincentdao.pimtoolback.application.project.request.ViewProjectsWithFiltersPaginatedRequest;
import com.vincentdao.pimtoolback.domain.employee.Employee;
import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.project.Project;
import com.vincentdao.pimtoolback.infrastructure.custom.annotation.component.Gateway;
import com.vincentdao.pimtoolback.infrastructure.datasource.EmployeeDs;
import com.vincentdao.pimtoolback.infrastructure.datasource.ProjectDs;
import com.vincentdao.pimtoolback.infrastructure.datasource.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Gateway
public class ViewProjectsWithFiltersPaginatedGatewayImpl implements ViewProjectsWithFiltersPaginatedGateway {

    private final ProjectDs projectDs;
    private final EmployeeDs employeeDs;

    @Autowired
    public ViewProjectsWithFiltersPaginatedGatewayImpl(ProjectDs projectDs, EmployeeDs employeeDs) {
        this.projectDs = projectDs;
        this.employeeDs = employeeDs;
    }

    @Override
    public List<Project> getProjectsWithFiltersPaginated(ViewProjectsWithFiltersPaginatedRequest input, int pageSize) {
        return projectDs.findAll()
                .stream()
                .map(ProjectMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getProjectEmployeesByIds(List<EmployeeId> projectEmployeeIds) {
        return projectEmployeeIds.stream()
                .map(id -> employeeDs.findById(id.value()).orElseThrow().mapTo())
                .collect(Collectors.toList());
    }
}
