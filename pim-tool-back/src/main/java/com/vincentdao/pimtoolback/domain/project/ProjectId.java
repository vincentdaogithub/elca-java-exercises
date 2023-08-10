package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.project.exception.InvalidProjectIdException;

public record ProjectId(Long value) {

    public ProjectId {
        if (value == null || value < 1) {
            throw new InvalidProjectIdException();
        }
    }
}
