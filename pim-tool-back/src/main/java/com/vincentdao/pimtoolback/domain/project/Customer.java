package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.project.exception.EmptyCustomerNameException;
import com.vincentdao.pimtoolback.domain.project.exception.InvalidCustomerNameException;
import org.apache.commons.lang3.StringUtils;

public record Customer(String name) {

    private static final int MAX_NAME_LENGTH = 50;

    public Customer {
        if (StringUtils.isAllBlank(name)) {
            throw new EmptyCustomerNameException();
        }
        if (name.trim().length() != name.length() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidCustomerNameException(MAX_NAME_LENGTH);
        }
    }
}
