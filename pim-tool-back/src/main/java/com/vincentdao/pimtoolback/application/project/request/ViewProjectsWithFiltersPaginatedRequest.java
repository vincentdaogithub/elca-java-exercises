/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.application.project.request;

import com.vincentdao.pimtoolback.domain.project.ProjectStatus;

public record ViewProjectsWithFiltersPaginatedRequest(String searchQuery, String status) {

    public ViewProjectsWithFiltersPaginatedRequest {
        if (searchQuery == null || status == null) {
            throw new IllegalArgumentException("Arguments are null or empty");
        }
        ProjectStatus.convertFrom(status);
    }
}
