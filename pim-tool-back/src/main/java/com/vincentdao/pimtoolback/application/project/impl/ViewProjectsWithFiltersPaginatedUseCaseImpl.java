/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.application.project.impl;

import com.vincentdao.pimtoolback.application.project.ViewProjectsWithFiltersPaginatedUseCase;
import com.vincentdao.pimtoolback.application.project.gateway.ViewProjectsWithFiltersPaginatedGateway;
import com.vincentdao.pimtoolback.application.project.request.ViewProjectsWithFiltersPaginatedRequest;
import com.vincentdao.pimtoolback.application.project.response.ProjectEmployeeResponse;
import com.vincentdao.pimtoolback.application.project.response.ProjectResponse;
import com.vincentdao.pimtoolback.infrastructure.custom.annotation.component.UseCase;

import java.util.List;

@UseCase
public class ViewProjectsWithFiltersPaginatedUseCaseImpl implements ViewProjectsWithFiltersPaginatedUseCase {

    private static final int PAGE_SIZE = 10;

    private final ViewProjectsWithFiltersPaginatedGateway gateway;

    public ViewProjectsWithFiltersPaginatedUseCaseImpl(ViewProjectsWithFiltersPaginatedGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ProjectResponse> getProjects(ViewProjectsWithFiltersPaginatedRequest input) {
        return gateway.getProjectsWithFiltersPaginated(input, PAGE_SIZE)
                .stream()
                .map(p -> new ProjectResponse(
                        p.getId().value(),
                        p.getProjectGroup().groupLeaderId().value(),
                        p.getProjectNumber().value(),
                        p.getProjectName().value(),
                        p.getProjectCustomer().name(),
                        p.getProjectStatus().getStatusCode(),
                        p.getProjectDuration().startDate(),
                        p.getProjectDuration().endDate(),
                        gateway.getProjectEmployeesByIds(p.getProjectEmployees())
                                .stream()
                                .map(e -> new ProjectEmployeeResponse(
                                        e.getId().value(),
                                        e.getVisa().value()
                                ))
                                .toList()
                ))
                .toList();
    }
}
