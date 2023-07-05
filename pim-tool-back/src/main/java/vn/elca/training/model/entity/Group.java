package vn.elca.training.model.entity;

import vn.elca.training.model.validator.EntityValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "GROUP_")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 19)
    private BigDecimal id;

    @OneToOne(optional = false)
    @JoinColumn(name = "group_leader_id")
    private Employee groupLeader;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Project> projects;

    @Version
    @Column(nullable = false)
    private Long version;

    public Group() { }

    public Group(Employee groupLeader, Set<Project> projects, Long version) {
        setGroupLeader(groupLeader);
        this.projects = projects;
        setVersion(version);
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        EntityValidator.validateId(id);
        this.id = id;
    }

    public Employee getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Employee groupLeader) {
        EntityValidator.validateNotNull(groupLeader, "groupLeader");
        this.groupLeader = groupLeader;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        EntityValidator.validateVersion(version);
        this.version = version;
    }
}
