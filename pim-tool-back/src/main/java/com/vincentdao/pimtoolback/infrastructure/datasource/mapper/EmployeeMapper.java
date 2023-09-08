/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.datasource.mapper;

import com.vincentdao.pimtoolback.domain.employee.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMapper implements Mapper<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 3)
    private String visa;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Version
    @Column(nullable = false)
    private Long version;

    @OneToOne(mappedBy = "groupLeader")
    private GroupMapper ledGroup;

    @ManyToMany(mappedBy = "projectEmployees")
    private List<ProjectMapper> assignedProjects;

    @Override
    public Employee mapTo() {
        Employee mappedEmployee = new Employee(
                new EmployeeId(id),
                new EmployeeVisa(visa),
                new EmployeeName(firstName, lastName),
                new EmployeeBirthDate(birthDate)
        );
        mappedEmployee.validate();
        return mappedEmployee;
    }
}
