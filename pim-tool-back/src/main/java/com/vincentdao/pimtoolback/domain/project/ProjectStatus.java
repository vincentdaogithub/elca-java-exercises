package com.vincentdao.pimtoolback.domain.project;

import org.apache.commons.text.WordUtils;

public enum ProjectStatus {

    NEW, PENDING, IN_PROGRESS, FINISHED;

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(this.name(), '_');
    }
}
