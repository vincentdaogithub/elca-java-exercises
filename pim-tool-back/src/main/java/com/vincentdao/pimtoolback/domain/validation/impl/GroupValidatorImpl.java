package com.vincentdao.pimtoolback.domain.validation.impl;

import java.math.BigDecimal;

import com.vincentdao.pimtoolback.domain.entity.Group;
import com.vincentdao.pimtoolback.domain.exception.impl.ValidationException;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;

public class GroupValidatorImpl implements DomainValidator<Group> {

    @Override
    public void validate(Group entity) {
        validateId(entity.getId());
        validateGroupLeaderId(entity.getGroupLeaderId());
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

    private void validateGroupLeaderId(BigDecimal groupLeaderId) {
        if (groupLeaderId == null) {
            throw new ValidationException("Group leader id is null");
        }
        if (groupLeaderId.scale() > 0) {
            throw new ValidationException("Group leader id is not integer");
        }
        if (groupLeaderId.compareTo(BigDecimal.ZERO) < 0 || groupLeaderId.precision() > 19) {
            throw new ValidationException("Group leader id is below 0 or above 19 digits");
        }
    }
}
