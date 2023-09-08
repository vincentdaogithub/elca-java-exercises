/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.group.GroupId;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class ProjectTest {

    private static Stream<Arguments> validProjectTestData() {
        return Stream.of(
                Arguments.of(
                        1L,
                        1L,
                        1L,
                        1,
                        "A",
                        "A",
                        ProjectStatus.NEW,
                        LocalDate.now(),
                        null,
                        new ArrayList<EmployeeId>()
                ),
                Arguments.of(
                        Long.MAX_VALUE,
                        Long.MAX_VALUE,
                        Long.MAX_VALUE,
                        9999,
                        StringUtils.repeat("A", 50),
                        StringUtils.repeat("A", 50),
                        ProjectStatus.PENDING,
                        LocalDate.now(),
                        LocalDate.now().minusDays(1),
                        new ArrayList<>(List.of(new EmployeeId(1L)))
                ),
                Arguments.of(
                        RandomUtils.nextLong(1, Long.MAX_VALUE),
                        RandomUtils.nextLong(1, Long.MAX_VALUE),
                        RandomUtils.nextLong(1, Long.MAX_VALUE),
                        RandomUtils.nextInt(1, 10000),
                        StringUtils.repeat("A", RandomUtils.nextInt(1, 51)),
                        StringUtils.repeat("A", RandomUtils.nextInt(1, 51)),
                        ProjectStatus.IN_PROGRESS,
                        LocalDate.now(),
                        LocalDate.now().minusDays(18),
                        new ArrayList<>(List.of(new EmployeeId(Long.MAX_VALUE)))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("validProjectTestData")
    void givenProject_whenAllParamsAreValid_thenProjectIsCreated(
            Long id,
            Long groupId,
            Long groupLeaderId,
            Integer projectNumber,
            String projectName,
            String customerName,
            ProjectStatus projectStatus,
            LocalDate startDate,
            LocalDate endDate,
            List<EmployeeId> projectEmployees) {
        assertThatNoException().isThrownBy(() -> {
            new Project(
                    new ProjectId(id),
                    new ProjectGroup(new GroupId(groupId), new EmployeeId(groupLeaderId)),
                    new ProjectNumber(projectNumber),
                    new ProjectName(projectName),
                    new ProjectCustomer(customerName),
                    projectStatus,
                    new ProjectDuration(startDate, endDate),
                    projectEmployees
            );
        });
    }

    @Test
    void givenProject_whenAllParamsAreValidAndIdIsNull_thenProjectIsCreated() {
        assertThatNoException().isThrownBy(() -> {
            new Project(
                    null,
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            );
        });
    }

    private static Stream<Arguments> invalidProjectIdTestData() {
        return Stream.of(
                Arguments.of(0L),
                Arguments.of(-1L),
                Arguments.of(null, 0L)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProjectIdTestData")
    void givenProject_whenIdValueIsInvalid_thenThrowException(Long id) {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(id),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            );
        });
    }

    private static Stream<Arguments> invalidProjectGroupTestData() {
        return Stream.of(
                Arguments.of(null, new EmployeeId(1L)),
                Arguments.of(new GroupId(1L), null)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProjectGroupTestData")
    void givenProject_whenProjectGroupValueIsInvalid_thenThrowException(GroupId groupId, EmployeeId groupLeaderId) {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(groupId, groupLeaderId),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            );
        });
    }

    private static Stream<Arguments> invalidProjectNumberTestData() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1),
                Arguments.of(10000),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProjectNumberTestData")
    void givenProject_whenProjectNumberValueIsInvalid_thenThrowException(Integer projectNumber) {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(projectNumber),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            );
        });
    }

    private static Stream<Arguments> invalidProjectNameTestData() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("A "),
                Arguments.of(" A"),
                Arguments.of(null, "")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProjectNameTestData")
    void givenProject_whenProjectNameValueIsInvalid_thenThrowException(String projectName) {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName(projectName),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            );
        });
    }

    @ParameterizedTest
    @MethodSource("invalidProjectNameTestData")
    void givenProject_whenProjectCustomerValueIsInvalid_thenThrowException(String projectCustomerName) {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer(projectCustomerName),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            );
        });
    }

    private static Stream<Arguments> invalidProjectDurationTestData() {
        LocalDate currentDate = LocalDate.now();
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(currentDate, currentDate.plusDays(1)),
                Arguments.of(currentDate, currentDate)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProjectDurationTestData")
    void givenProject_whenProjectDurationValueIsInvalid_thenThrowException(LocalDate startDate, LocalDate endDate) {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(startDate, endDate),
                    new ArrayList<>()
            );
        });
    }

    @Test
    void givenProject_whenRequiredParamIsNull_thenThrowException() {
        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    null,
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            ).validate();
        });

        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    null,
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            ).validate();
        });

        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    null,
                    new ProjectCustomer("B"),
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            ).validate();
        });

        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    null,
                    ProjectStatus.FINISHED,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            ).validate();
        });

        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    null,
                    new ProjectDuration(LocalDate.now(), null),
                    new ArrayList<>()
            ).validate();
        });

        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.PENDING,
                    null,
                    new ArrayList<>()
            ).validate();
        });

        assertThatException().isThrownBy(() -> {
            new Project(
                    new ProjectId(1L),
                    new ProjectGroup(new GroupId(1L), new EmployeeId(1L)),
                    new ProjectNumber(1),
                    new ProjectName("A"),
                    new ProjectCustomer("B"),
                    ProjectStatus.PENDING,
                    new ProjectDuration(LocalDate.now(), null),
                    null
            ).validate();
        });
    }
}
