package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.exception.EndDateIsNotBeforeStartDateException;

import java.time.LocalDate;
import java.util.Objects;

public record ProjectDuration(LocalDate startDate, LocalDate endDate) {

    public ProjectDuration {
        Objects.requireNonNull(startDate, "Start date must not be null");
        if (endDate != null && !endDate.isBefore(startDate)) {
            throw new EndDateIsNotBeforeStartDateException();
        }
    }
}
