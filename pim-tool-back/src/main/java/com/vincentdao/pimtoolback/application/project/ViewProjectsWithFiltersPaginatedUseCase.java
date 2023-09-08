/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.application.project;

import com.vincentdao.pimtoolback.application.project.request.ViewProjectsWithFiltersPaginatedRequest;
import com.vincentdao.pimtoolback.application.project.response.ProjectResponse;

import java.util.List;

public interface ViewProjectsWithFiltersPaginatedUseCase {

    List<ProjectResponse> getProjects(ViewProjectsWithFiltersPaginatedRequest input);
}
