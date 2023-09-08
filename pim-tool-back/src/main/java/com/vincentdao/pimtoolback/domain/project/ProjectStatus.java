package com.vincentdao.pimtoolback.domain.project;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

@Getter
public enum ProjectStatus {

    NEW("NEW"), PENDING("PEN"), IN_PROGRESS("INP"), FINISHED("FIN");

    private final String statusCode;

    ProjectStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(this.name(), '_');
    }

    public static ProjectStatus convertFrom(String statusCode) {
        if (StringUtils.isBlank(statusCode)) {
            throw new IllegalArgumentException("Status code must not be null or empty");
        }
        for (ProjectStatus status : ProjectStatus.values()) {
            if (status.statusCode.equals(statusCode)) {
                return status;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown status code '%s'", statusCode));
    }
}
