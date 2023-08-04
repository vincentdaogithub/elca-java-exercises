package com.vincentdao.pimtoolback.domain.status;

import org.apache.commons.text.WordUtils;

import com.vincentdao.pimtoolback.domain.exception.impl.InvalidProjectStatusException;

public enum ProjectStatuses {

    NEW("NEW"), PLANNED("PLA"), IN_PROGRESS("INP"), FINISHED("FIN");

    private final String code;

    private ProjectStatuses(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ProjectStatuses convert(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Null code");
        }
        for (ProjectStatuses projectStatus : ProjectStatuses.values()) {
            if (projectStatus.getCode().equals(code)) {
                return projectStatus;
            }
        }
        throw new InvalidProjectStatusException();
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(this.name().replace("_", " "));
    }
}
