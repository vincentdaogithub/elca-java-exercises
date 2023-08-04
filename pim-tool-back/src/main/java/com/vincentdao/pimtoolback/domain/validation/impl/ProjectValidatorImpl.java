package com.vincentdao.pimtoolback.domain.validation.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import com.vincentdao.pimtoolback.domain.entity.Project;
import com.vincentdao.pimtoolback.domain.exception.ProjectEndDateNotAfterStartDateException;
import com.vincentdao.pimtoolback.domain.exception.ValidationException;
import com.vincentdao.pimtoolback.domain.status.ProjectStatuses;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;

public class ProjectValidatorImpl implements DomainValidator<Project> {

    @Override
    public void validate(Project entity) {
        validateId(entity.getId());
        validateGroupId(entity.getGroupId());
        validateProjectEmployeeIds(entity.getProjectEmployeeIds());
        validateProjectNumber(entity.getProjectNumber());
        validateName(entity.getName());
        validateCustomer(entity.getCustomer());
        validateStatus(entity.getStatus());
        validateProjectDate(entity.getStartDate(), entity.getEndDate());
    }

    private void validateId(BigDecimal id) {
        if (id == null) {
            throw new ValidationException("Id is null");
        }
        if (id.scale() > 0) {
            throw new ValidationException("Id is not integer");
        }
        if (id.compareTo(BigDecimal.ZERO) < 0 || id.precision() > 19) {
            throw new ValidationException("Id is below 0 or above 19 digits");
        }
    }

    private void validateGroupId(BigDecimal groupId) {
        if (groupId == null) {
            throw new ValidationException("Group id is null");
        }
        if (groupId.scale() > 0) {
            throw new ValidationException("Group id is not integer");
        }
        if (groupId.compareTo(BigDecimal.ZERO) < 0 || groupId.precision() > 19) {
            throw new ValidationException("Group id is below 0 or above 19 digits");
        }
    }

    private void validateProjectNumber(Integer projectNumber) {
        if (projectNumber == null) {
            throw new ValidationException("Project number is null");
        }
        if (projectNumber < 0 || projectNumber > 9999) {
            throw new ValidationException("Project number is below 0 or above 4 digits");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException("Name is null or empty");
        }
        if (name.length() > 50) {
            throw new ValidationException("Name length exceeds length of 50 characters");
        }
    }

    private void validateCustomer(String customer) {
        if (customer == null || customer.isBlank()) {
            throw new ValidationException("Customer is null or empty");
        }
        if (customer.length() > 50) {
            throw new ValidationException("Customer length exceeds length of 50 characters");
        }
    }

    private void validateStatus(String status) {
        if (status == null || status.isBlank()) {
            throw new ValidationException("Project status is null or empty");
        }
        ProjectStatuses.convert(status);
    }

    private void validateProjectDate(Date startDate, Date endDate) {
        if (startDate == null) {
            throw new ValidationException("Start date is null");
        }
        if (endDate.after(startDate)) {
            throw new ProjectEndDateNotAfterStartDateException();
        }
    }

    private void validateProjectEmployeeId(BigDecimal projectEmployeeId) {
        if (projectEmployeeId == null) {
            throw new ValidationException("Project employee id is null");
        }
        if (projectEmployeeId.scale() > 0) {
            throw new ValidationException("Project employee id is not integer");
        }
        if (projectEmployeeId.compareTo(BigDecimal.ZERO) < 0 || projectEmployeeId.precision() > 19) {
            throw new ValidationException("Project employee id is below 0 or above 19 digits");
        }
    }

    private void validateProjectEmployeeIds(Collection<BigDecimal> projectEmployeeIds) {
        projectEmployeeIds.stream().forEach(this::validateProjectEmployeeId);
    }
}
