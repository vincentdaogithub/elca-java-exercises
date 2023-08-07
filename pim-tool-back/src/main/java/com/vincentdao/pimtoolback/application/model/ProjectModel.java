package com.vincentdao.pimtoolback.application.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public record ProjectModel(BigDecimal id, Integer projectNumber, String projectName, String projectCustomer,
        String status, String startDate, String endDate, Collection<String> projectEmployees) {

    public ProjectModel {
        Objects.requireNonNull(id);
        Objects.requireNonNull(projectNumber);
        Objects.requireNonNull(projectName);
        Objects.requireNonNull(projectName);
        Objects.requireNonNull(projectCustomer);
        Objects.requireNonNull(status);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        Objects.requireNonNull(projectEmployees);
    }
}
