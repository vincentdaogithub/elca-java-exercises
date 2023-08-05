package com.vincentdao.pimtoolback.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.vincentdao.pimtoolback.domain.builder.EmployeeBuilder;
import com.vincentdao.pimtoolback.domain.builder.impl.EmployeeBuilderImpl;
import com.vincentdao.pimtoolback.domain.entity.Employee;
import com.vincentdao.pimtoolback.domain.exception.impl.ValidationException;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;
import com.vincentdao.pimtoolback.domain.validation.impl.EmployeeValidatorImpl;

class EmployeeTest {

    private final EmployeeBuilder builder;
    private final DomainValidator<Employee> validator;
    private Employee employee;

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
        this.builder.setBirthDate(LocalDate.of(2003, 12, 6));
        this.employee = this.builder.build();
    }

    @Test
    void givenEmployee_whenValid_thenValidationDoesNotThrowException() {
        assertThatCode((() -> this.validator.validate(employee))).doesNotThrowAnyException();
    }

    private static Stream<BigDecimal> idTestArgs() {
        return Stream.of(null, new BigDecimal("-1"), new BigDecimal("10000000000000000000"));
    }

    @ParameterizedTest
    @MethodSource("idTestArgs")
    void givenEmployee_whenIdIsInvalid_thenValidationThrowsException(BigDecimal id) {
        this.employee.setId(id);
        assertThatThrownBy(() -> this.validator.validate(employee)).isInstanceOf(ValidationException.class);
    }

    private static Stream<String> visaTestArgs() {
        return Stream.of(null, "", " ", "AA", "AAAA", "AA ", " AA", "abc");
    }

    @ParameterizedTest
    @MethodSource("visaTestArgs")
    void givenEmployee_whenVisaIsInvalid_thenValidationThrowsException(String visa) {
        this.employee.setVisa(visa);
        assertThatThrownBy(() -> this.validator.validate(employee)).isInstanceOf(ValidationException.class);
    }

    private static Stream<String> nameTestArgs() {
        return Stream.of(null, "", " ", " a", "a ", StringUtils.repeat("a", 51));
    }

    @ParameterizedTest
    @MethodSource("nameTestArgs")
    void givenEmployee_whenFirstNameIsInvalid_thenValidationThrowsException(String firstName) {
        this.employee.setFirstName(firstName);
        assertThatThrownBy(() -> this.validator.validate(employee)).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @MethodSource("nameTestArgs")
    void givenEmployee_whenLastNameIsInvalid_thenValidationThrowsException(String lastName) {
        this.employee.setLastName(lastName);
        assertThatThrownBy(() -> this.validator.validate(employee)).isInstanceOf(ValidationException.class);
    }

    private static Stream<LocalDate> birthDateTestArgs() {
        return Stream.of(null, LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @ParameterizedTest
    @MethodSource("birthDateTestArgs")
    void givenEmployee_whenBirthDateIsInvalid_thenValidationThrowsException(LocalDate birthDate) {
        this.employee.setBirthDate(birthDate);
        assertThatThrownBy(() -> this.validator.validate(employee)).isInstanceOf(ValidationException.class);
    }

    @AfterEach
    void destroy() {
        this.employee = null;
    }
}
