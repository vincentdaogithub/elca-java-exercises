/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.datasource.mapper;

import com.vincentdao.pimtoolback.domain.employee.EmployeeId;
import com.vincentdao.pimtoolback.domain.group.Group;
import com.vincentdao.pimtoolback.domain.group.GroupId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "GROUP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupMapper implements Mapper<Group> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(nullable = false)
    private Long version;

    @OneToOne(optional = false)
    @JoinColumn(name = "GROUP_LEADER_ID", nullable = false)
    private EmployeeMapper groupLeader;

    @OneToMany(mappedBy = "projectGroup")
    private List<ProjectMapper> ledProjects;

    @Override
    public Group mapTo() {
        Group mappedGroup = new Group(
                new GroupId(id),
                new EmployeeId(groupLeader.getId())
        );
        mappedGroup.validate();
        return mappedGroup;
    }
}
