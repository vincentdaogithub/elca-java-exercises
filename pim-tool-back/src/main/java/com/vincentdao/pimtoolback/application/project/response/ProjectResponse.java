/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.application.project.response;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record ProjectResponse(Long id, Long groupLeaderId, Integer projectNumber, String projectName,
                              String projectCustomer, String projectStatus, LocalDate projectStartDate,
                              LocalDate projectEndDate, List<ProjectEmployeeResponse> projectEmployees) {

    public ProjectResponse {
        Objects.requireNonNull(id, "Id must not be null");
        Objects.requireNonNull(projectNumber, "Project number must not be null");
        Objects.requireNonNull(projectName, "Project name must not be null");
        Objects.requireNonNull(projectCustomer, "Project customer must not be null");
        Objects.requireNonNull(projectStatus, "Project status must not be null");
        Objects.requireNonNull(projectStartDate, "Project start date must not be null");
        Objects.requireNonNull(projectEndDate, "Project end date must not be null");
        Objects.requireNonNull(projectEmployees, "Project employees must not be null");
    }
}
