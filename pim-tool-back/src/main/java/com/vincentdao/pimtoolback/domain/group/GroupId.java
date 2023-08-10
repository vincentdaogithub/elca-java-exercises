package com.vincentdao.pimtoolback.domain.group;

import com.vincentdao.pimtoolback.domain.group.exception.InvalidGroupIdException;

public record GroupId(Long value) {

    public GroupId {
        if (value == null || value < 1) {
            throw new InvalidGroupIdException();
        }
    }
}
