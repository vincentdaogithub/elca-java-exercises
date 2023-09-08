/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.domain.group;

import com.vincentdao.pimtoolback.domain.employee.*;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class GroupTest {

    private static Stream<Arguments> validGroupTestData() {
        return Stream.of(
                Arguments.of(1L, 1L),
                Arguments.of(Long.MAX_VALUE, Long.MAX_VALUE),
                Arguments.of(RandomUtils.nextLong(1, Long.MAX_VALUE), RandomUtils.nextLong(1, Long.MAX_VALUE))
        );
    }

    @ParameterizedTest
    @MethodSource("validGroupTestData")
    void givenGroup_whenAllParamsAreValid_thenGroupIsCreated(Long id, Long groupLeaderId) {
        assertThatNoException().isThrownBy(() -> {
            new Group(
                    new GroupId(id),
                    new EmployeeId(groupLeaderId)
            );
        });
    }

    @Test
    void givenGroup_whenAllParamsAreValidAndIdIsNull_thenGroupIsCreated() {
        assertThatNoException().isThrownBy(() -> {
            new Group(
                    null,
                    new EmployeeId(1L)
            );
        });
    }

    private static Stream<Arguments> invalidIdTestData() {
        return Stream.of(
                Arguments.of(0L),
                Arguments.of(-1L),
                Arguments.of(null, 0L)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidIdTestData")
    void givenGroup_whenIdValueIsInvalid_thenThrowException(Long id) {
        assertThatException().isThrownBy(() -> {
            new Group(
                    new GroupId(id),
                    new EmployeeId(1L)
            );
        });
    }

    @ParameterizedTest
    @MethodSource("invalidIdTestData")
    void givenGroup_whenGroupLeaderIdValueIsInvalid_thenThrowException(Long groupLeaderId) {
        assertThatException().isThrownBy(() -> {
            new Group(
                    new GroupId(1L),
                    new EmployeeId(groupLeaderId)
            );
        });
    }

    @Test
    void givenGroup_whenRequiredParamIsNull_thenThrowException() {
        assertThatException().isThrownBy(() -> {
            new Group(
                    new GroupId(1L),
                    null
            ).validate();
        });
    }
}
