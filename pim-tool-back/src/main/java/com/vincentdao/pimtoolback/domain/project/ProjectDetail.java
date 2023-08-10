package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.project.exception.*;
import org.apache.commons.lang3.StringUtils;

public record ProjectDetail(Integer projectNumber, String projectName, Customer customer) {

    private static final int MAX_PROJECT_NUMBER = 9999;
    private static final int MAX_NAME_LENGTH = 50;

    public ProjectDetail {
        if (projectNumber == null) {
            throw new EmptyProjectNumberException();
        }
        if (projectNumber < 1 || projectNumber > MAX_PROJECT_NUMBER) {
            throw new ProjectNumberNotInRangeException(MAX_PROJECT_NUMBER);
        }

        if (StringUtils.isAllBlank(projectName)) {
            throw new EmptyProjectNameException();
        }
        if (projectName.trim().length() != projectName.length() || projectName.length() > MAX_NAME_LENGTH) {
            throw new InvalidProjectNameException(MAX_NAME_LENGTH);
        }

        if (customer == null) {
            throw new EmptyCustomerException();
        }
    }
}
