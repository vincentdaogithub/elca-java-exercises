/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.domain.employee;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class EmployeeTest {

    private static Stream<Arguments> validEmployeeTestData() {
        return Stream.of(
            Arguments.of(
                    1L,
                    "ABC",
                    "J",
                    "D",
                    LocalDate.now().minusYears(18)),
            Arguments.of(
                    Long.MAX_VALUE,
                    "DEF",
                    StringUtils.repeat("J", 50),
                    StringUtils.repeat("D", 50),
                    LocalDate.now().minusYears(18).minusDays(1)),
            Arguments.of(
                    RandomUtils.nextLong(1, Long.MAX_VALUE),
                    "GHI",
                    StringUtils.repeat("J", RandomUtils.nextInt(1, 50)),
                    StringUtils.repeat("D", RandomUtils.nextInt(1, 50)),
                    LocalDate.of(1996, 11, 30)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("validEmployeeTestData")
    void givenEmployee_whenAllParamsAreValid_thenEmployeeIsCreated(
            Long id,
            String visa,
            String firstName,
            String lastName,
            LocalDate birthDate) {
        assertThatNoException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(id),
                    new EmployeeVisa(visa),
                    new EmployeeName(firstName, lastName),
                    new EmployeeBirthDate(birthDate)
            );
        });
    }

    @Test
    void givenEmployee_whenAllParamsAreValidAndIdIsNull_thenEmployeeIsCreated() {
        assertThatNoException().isThrownBy(() -> {
            new Employee(
                    null,
                    new EmployeeVisa("ABC"),
                    new EmployeeName("John", "Doe"),
                    new EmployeeBirthDate(LocalDate.of(2000, 12, 31))
            );
        });
    }

    private static Stream<Arguments> invalidEmployeeIdTestData() {
        return Stream.of(
                Arguments.of(0L),
                Arguments.of(-1L),
                Arguments.of(null, 0L)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidEmployeeIdTestData")
    void givenEmployee_whenIdValueIsInvalid_thenThrowException(Long id) {
        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(id),
                    new EmployeeVisa("ABC"),
                    new EmployeeName("John", "Doe"),
                    new EmployeeBirthDate(LocalDate.of(2000, 12, 31))
            );
        });
    }

    private static Stream<Arguments> invalidEmployeeVisaTestData() {
        return Stream.of(
                Arguments.of("A"),
                Arguments.of("AAAA"),
                Arguments.of("A A"),
                Arguments.of(" AA"),
                Arguments.of("AA "),
                Arguments.of("A A"),
                Arguments.of("aAa"),
                Arguments.of(null, "")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidEmployeeVisaTestData")
    void givenEmployee_whenVisaValueIsInvalid_thenThrowException(String visa) {
        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(1L),
                    new EmployeeVisa(visa),
                    new EmployeeName("John", "Doe"),
                    new EmployeeBirthDate(LocalDate.of(2000, 12, 31))
            );
        });
    }

    private static Stream<Arguments> invalidEmployeeNameTestData() {
        return Stream.of(
                Arguments.of("", "A"),
                Arguments.of("A", ""),
                Arguments.of(" ", "A"),
                Arguments.of("A", " "),
                Arguments.of(" A", "A"),
                Arguments.of("A ", "A"),
                Arguments.of("A", " A"),
                Arguments.of("A", "A "),
                Arguments.of(StringUtils.repeat("A", 51), "A"),
                Arguments.of("A", StringUtils.repeat("A", 51)),
                Arguments.of(null, "A"),
                Arguments.of("A", null)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidEmployeeNameTestData")
    void givenEmployee_whenNameValueIsInvalid_thenThrowException(String firstName, String lastName) {
        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(1L),
                    new EmployeeVisa("ABC"),
                    new EmployeeName(firstName, lastName),
                    new EmployeeBirthDate(LocalDate.of(2000, 12, 31))
            );
        });
    }

    private static Stream<Arguments> invalidEmployeeBirthDateTestData() {
        LocalDate currentDate = LocalDate.now();
        return Stream.of(
                Arguments.of(currentDate.minusYears(17)),
                Arguments.of(currentDate.minusYears(18).plusDays(1)),
                Arguments.of(null, "")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidEmployeeBirthDateTestData")
    void givenEmployee_whenBirthDateValueIsInvalid_thenThrowException(LocalDate birthDate) {
        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(1L),
                    new EmployeeVisa("ABC"),
                    new EmployeeName("John", "Doe"),
                    new EmployeeBirthDate(birthDate)
            );
        });
    }

    @Test
    void givenEmployee_whenRequiredParamIsNull_thenThrowException() {
        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(1L),
                    null,
                    new EmployeeName("John", "Doe"),
                    new EmployeeBirthDate(LocalDate.now().minusYears(18))
            );
        });

        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(1L),
                    new EmployeeVisa("ABC"),
                    null,
                    new EmployeeBirthDate(LocalDate.now().minusYears(18))
            );
        });

        assertThatException().isThrownBy(() -> {
            new Employee(
                    new EmployeeId(1L),
                    new EmployeeVisa("ABC"),
                    new EmployeeName("John", "Doe"),
                    null
            );
        });
    }
}
