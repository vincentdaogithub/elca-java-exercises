package com.vincentdao.pimtoolback.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.vincentdao.pimtoolback.domain.builder.ProjectBuilder;
import com.vincentdao.pimtoolback.domain.builder.impl.ProjectBuilderImpl;
import com.vincentdao.pimtoolback.domain.entity.Project;
import com.vincentdao.pimtoolback.domain.exception.impl.InvalidProjectStatusException;
import com.vincentdao.pimtoolback.domain.exception.impl.ProjectEndDateNotAfterStartDateException;
import com.vincentdao.pimtoolback.domain.exception.impl.ValidationException;
import com.vincentdao.pimtoolback.domain.status.ProjectStatuses;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;
import com.vincentdao.pimtoolback.domain.validation.impl.ProjectValidatorImpl;

class ProjectTest {

    private final ProjectBuilder builder;
    private final DomainValidator<Project> validator;
    private Project project;

    public ProjectTest() {
        this.builder = new ProjectBuilderImpl();
        this.validator = new ProjectValidatorImpl();
    }

    @BeforeEach
    void init() {
        this.builder.setId(BigDecimal.ZERO);
        this.builder.setGroupId(BigDecimal.ZERO);
        this.builder.setProjectNumber(0);
        this.builder.setName("project name");
        this.builder.setCustomer("customer");
        this.builder.setStatus(ProjectStatuses.NEW.getCode());
        this.builder.setStartDate(LocalDate.now());
        this.builder.setEndDate(null);
        this.builder.setProjectEmployeeIds(Collections.emptyList());
        this.project = this.builder.build();
    }

    @Test
    void givenProject_whenValid_thenValidationDoesNotThrowException() {
        assertThatCode((() -> this.validator.validate(project))).doesNotThrowAnyException();
    }

    private static Stream<BigDecimal> idTestArgs() {
        return Stream.of(null, new BigDecimal("-1"), new BigDecimal("10000000000000000000"));
    }

    @ParameterizedTest
    @MethodSource("idTestArgs")
    void givenProject_whenIdIsInvalid_thenValidationThrowsException(BigDecimal id) {
        this.project.setId(id);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @MethodSource("idTestArgs")
    void givenProject_whenGroupIdIsInvalid_thenValidationThrowsException(BigDecimal groupId) {
        this.project.setId(groupId);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOf(ValidationException.class);
    }

    private static Stream<Integer> projectNumberTestArgs() {
        return Stream.of(null, -1, 10000);
    }

    @ParameterizedTest
    @MethodSource("projectNumberTestArgs")
    void givenProject_whenProjectNumberIsInvalid_thenValidationThrowsException(Integer projectNumber) {
        this.project.setProjectNumber(projectNumber);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOf(ValidationException.class);
    }

    private static Stream<String> stringMaxLength50TestArgs() {
        return Stream.of(null, "", " ", " a", "a ", StringUtils.repeat("a", 51));
    }

    @ParameterizedTest
    @MethodSource("stringMaxLength50TestArgs")
    void givenProject_whenNameIsInvalid_thenValidationThrowsException(String name) {
        this.project.setName(name);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @MethodSource("stringMaxLength50TestArgs")
    void givenProject_whenCustomerIsInvalid_thenValidationThrowsException(String customer) {
        this.project.setCustomer(customer);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOf(ValidationException.class);
    }

    private static Stream<String> projectStatusTestArgs() {
        return Stream.of(null, "", " ", "new", "PLa", "InP", "fIn");
    }

    @ParameterizedTest
    @MethodSource("projectStatusTestArgs")
    void givenProject_whenProjectStatusIsInvalid_thenValidationThrowsException(String projectStatus) {
        this.project.setStatus(projectStatus);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOfAny(ValidationException.class,
                InvalidProjectStatusException.class);
    }

    private static Stream<String> projectStatusValidTestArgs() {
        return Stream.of("PLA", "INP", "FIN");
    }

    @ParameterizedTest
    @MethodSource("projectStatusValidTestArgs")
    void givenProject_whenProjectStatusIsValid_thenValidationDoesNotThrowException(String projectStatus) {
        this.project.setStatus(projectStatus);
        assertThatCode((() -> this.validator.validate(project))).doesNotThrowAnyException();
    }

    private static Stream<Arguments> dateTestArgs() {
        return Stream.of(Arguments.of(null, null), Arguments.of(null, LocalDate.now()),
                Arguments.of(LocalDate.now(), LocalDate.now().minusDays(1)));
    }

    @ParameterizedTest
    @MethodSource("dateTestArgs")
    void givenProject_whenDateIsInvalid_thenValidationThrowsException(LocalDate startDate, LocalDate endDate) {
        this.project.setStartDate(startDate);
        this.project.setEndDate(endDate);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOfAny(ValidationException.class,
                ProjectEndDateNotAfterStartDateException.class);
    }

    private static Stream<Collection<BigDecimal>> projectEmployeeIdsTestArgs() {
        return Stream.of(Arrays.asList(BigDecimal.ZERO, null, BigDecimal.ONE),
                Arrays.asList(BigDecimal.ZERO, new BigDecimal(-1), BigDecimal.ONE),
                Arrays.asList(BigDecimal.ZERO, new BigDecimal("10000000000000000000")));
    }

    @ParameterizedTest
    @MethodSource("projectEmployeeIdsTestArgs")
    void givenProject_whenProjectEmployeeIdsIsInvalid_thenValidationThrowsException(
            Collection<BigDecimal> projectEmployeeIds) {
        this.project.setProjectEmployeeIds(projectEmployeeIds);
        assertThatThrownBy(() -> this.validator.validate(project)).isInstanceOf(ValidationException.class);
    }
}
