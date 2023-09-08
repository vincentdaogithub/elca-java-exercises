/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.datasource.mapper;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.group.GroupId;
import com.vincentdao.pimtoolback.domain.project.*;
import com.vincentdao.pimtoolback.infrastructure.datasource.mapper.converter.ProjectStatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "PROJECT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMapper implements Mapper<Project> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private GroupMapper projectGroup;

    @Column(unique = true, nullable = false)
    private Integer projectNumber;

    @Column(name = "NAME", nullable = false, length = 50)
    private String projectName;

    @Column(name = "CUSTOMER", nullable = false, length = 50)
    private String projectCustomer;

    @Column(name = "STATUS", nullable = false, length = 3)
    @Convert(converter = ProjectStatusConverter.class)
    private ProjectStatus projectStatus;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate projectStartDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate projectEndDate;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "PROJECT_EMPLOYEE",
            joinColumns = @JoinColumn(name = "PROJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"PROJECT_ID", "EMPLOYEE_ID"})
    )
    private List<EmployeeMapper> projectEmployees;

    @Version
    @Column(nullable = false)
    private Long version;

    @Override
    public Project mapTo() {
        Project mappedProject = new Project(
                new ProjectId(id),
                new ProjectGroup(
                        new GroupId(projectGroup.getId()),
                        new EmployeeId(projectGroup.getGroupLeader().getId())),
                new ProjectNumber(projectNumber),
                new ProjectName(projectName),
                new ProjectCustomer(projectCustomer),
                projectStatus,
                new ProjectDuration(projectStartDate, projectEndDate),
                getProjectEmployees().stream()
                        .map(e -> new EmployeeId(e.getId()))
                        .collect(Collectors.toList())
        );
        mappedProject.validate();
        return mappedProject;
    }
}
