package com.vincentdao.pimtoolback.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.vincentdao.pimtoolback.domain.builder.GroupBuilder;
import com.vincentdao.pimtoolback.domain.builder.impl.GroupBuilderImpl;
import com.vincentdao.pimtoolback.domain.entity.Group;
import com.vincentdao.pimtoolback.domain.exception.impl.ValidationException;
import com.vincentdao.pimtoolback.domain.validation.DomainValidator;
import com.vincentdao.pimtoolback.domain.validation.impl.GroupValidatorImpl;

class GroupTest {

    private final GroupBuilder builder;
    private final DomainValidator<Group> validator;
    private Group group;

    public GroupTest() {
        this.builder = new GroupBuilderImpl();
        this.validator = new GroupValidatorImpl();
    }

    @BeforeEach
    void init() {
        this.builder.setId(BigDecimal.ZERO);
        this.builder.setGroupLeaderId(BigDecimal.ZERO);
        this.group = this.builder.build();
    }

    @Test
    void givenEmployee_whenValid_thenValidationDoesNotThrowException() {
        assertThatCode((() -> this.validator.validate(group))).doesNotThrowAnyException();
    }

    private static Stream<BigDecimal> idTestArgs() {
        return Stream.of(null, new BigDecimal("-1"), new BigDecimal("10000000000000000000"));
    }

    @ParameterizedTest
    @MethodSource("idTestArgs")
    void givenEmployee_whenIdIsInvalid_thenValidationThrowsException(BigDecimal id) {
        this.group.setId(id);
        assertThatThrownBy(() -> this.validator.validate(group)).isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @MethodSource("idTestArgs")
    void givenEmployee_whenGroupLeaderIdIsInvalid_thenValidationThrowsException(BigDecimal groupLeaderId) {
        this.group.setGroupLeaderId(groupLeaderId);
        assertThatThrownBy(() -> this.validator.validate(group)).isInstanceOf(ValidationException.class);
    }
}
