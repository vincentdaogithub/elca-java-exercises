package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.project.exception.EmptyStartDateException;
import com.vincentdao.pimtoolback.domain.project.exception.EndDateIsNotAfterStartDateException;

import java.time.LocalDate;

public record ProjectDuration(LocalDate startDate, LocalDate endDate) {

    public ProjectDuration {
        if (startDate == null) {
            throw new EmptyStartDateException();
        }
        if (endDate != null) {
            if (!endDate.isAfter(startDate)) {
                throw new EndDateIsNotAfterStartDateException();
            }
        }
    }
}
