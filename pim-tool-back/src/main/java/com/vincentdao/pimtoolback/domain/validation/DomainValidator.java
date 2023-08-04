package com.vincentdao.pimtoolback.domain.validation;

public interface DomainValidator<T> {

    void validate(T entity);
}
