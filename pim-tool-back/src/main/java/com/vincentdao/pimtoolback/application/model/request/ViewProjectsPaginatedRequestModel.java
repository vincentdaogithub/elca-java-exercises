package com.vincentdao.pimtoolback.application.model.request;

import java.util.Objects;

import com.vincentdao.pimtoolback.application.exception.impl.InvalidRequestException;
import com.vincentdao.pimtoolback.domain.exception.DomainException;
import com.vincentdao.pimtoolback.domain.status.ProjectStatuses;

public record ViewProjectsPaginatedRequestModel(Integer page, String searchQuery, String status) {

    public ViewProjectsPaginatedRequestModel {
        Objects.requireNonNull(page);
        Objects.requireNonNull(searchQuery);
        Objects.requireNonNull(status);

        if (page < 1) {
            throw new InvalidRequestException("Page number is below 1");
        }
        if (searchQuery.length() > 255) {
            throw new InvalidRequestException("Search query exceeds 255 characters");
        }
        try {
            ProjectStatuses.convert(status);
        } catch (DomainException e) {
            throw new InvalidRequestException("Invalid project status", e);
        }
    }
}
