package com.vincentdao.pimtoolback.domain.validation;

import com.vincentdao.pimtoolback.domain.entity.Entity;

public interface DomainValidator<T extends Entity> {

    void validate(T entity);
}
