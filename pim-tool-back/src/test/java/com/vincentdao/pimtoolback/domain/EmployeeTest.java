package com.vincentdao.pimtoolback.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vincentdao.pimtoolback.domain.builder.EmployeeBuilder;
import com.vincentdao.pimtoolback.domain.builder.impl.EmployeeBuilderImpl;
import com.vincentdao.pimtoolback.domain.entity.Employee;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;
import com.vincentdao.pimtoolback.domain.validation.impl.EmployeeValidatorImpl;

class EmployeeTest {

    private final EmployeeBuilder builder;
    private final DomainValidator<Employee> validator;
    private Employee employeeToTest;

    public EmployeeTest() {
        this.builder = new EmployeeBuilderImpl();
        this.validator = new EmployeeValidatorImpl();
    }

    @BeforeEach
    void init() {
        this.builder.setId(BigDecimal.ZERO);
        this.builder.setVisa("ABC");
        this.builder.setFirstName("John");
        this.builder.setLastName("Doe");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.DECEMBER, 6);
        this.builder.setBirthDate(calendar.getTime());
        this.employeeToTest = this.builder.build();
    }

    @Test
    void givenEmployee_whenValid_thenValidationDoesNotThrowException() {
        assertThatCode((() -> this.validator.validate(employeeToTest))).doesNotThrowAnyException();
    }

    @AfterEach
    void destroy() {
        this.employeeToTest = null;
    }
}
