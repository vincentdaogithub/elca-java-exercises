/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.application.project.gateway;

import com.vincentdao.pimtoolback.application.project.request.ViewProjectsWithFiltersPaginatedRequest;
import com.vincentdao.pimtoolback.domain.employee.Employee;
import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.project.Project;

import java.util.List;

public interface ViewProjectsWithFiltersPaginatedGateway {

    List<Project> getProjectsWithFiltersPaginated(ViewProjectsWithFiltersPaginatedRequest input, int pageSize);

    List<Employee> getProjectEmployeesByIds(List<EmployeeId> projectEmployeeIds);
}
