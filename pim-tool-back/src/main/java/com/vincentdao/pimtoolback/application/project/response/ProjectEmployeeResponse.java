/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.application.project.response;

import java.util.Objects;

public record ProjectEmployeeResponse(Long id, String visa) {

    public ProjectEmployeeResponse {
        Objects.requireNonNull(id, "Id must not be null");
        Objects.requireNonNull(visa, "Visa must not be null");
    }
}
