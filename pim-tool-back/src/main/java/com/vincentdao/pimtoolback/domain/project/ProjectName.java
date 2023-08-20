package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.util.CustomStringUtils;
import org.apache.commons.lang3.StringUtils;

public record ProjectName(String value) {

    private static final int MAX_LENGTH = 50;

    public ProjectName {
        if (StringUtils.isBlank(value) || CustomStringUtils.hasTrailingSpaces(value)) {
            throw new IllegalArgumentException("Project name must not be null, empty, or has trailing spaces");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("Project name must not exceed %d characters", MAX_LENGTH));
        }
    }
}
