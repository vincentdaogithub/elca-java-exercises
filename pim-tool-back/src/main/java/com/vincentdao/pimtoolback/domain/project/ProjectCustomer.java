package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.util.CustomStringUtils;
import org.apache.commons.lang3.StringUtils;

public record ProjectCustomer(String name) {

    private static final int MAX_LENGTH = 50;

    public ProjectCustomer {
        if (StringUtils.isBlank(name) || CustomStringUtils.hasTrailingSpaces(name)) {
            throw new IllegalArgumentException("Project customer name must not be null, empty, or has trailing spaces");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Project customer name must not exceed %d characters",
                    MAX_LENGTH));
        }
    }
}
