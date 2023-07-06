package vn.elca.training.model.entity;

import vn.elca.training.model.validator.EntityValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
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
    private List<Project> projects;

    @Version
    @Column(nullable = false)
    private Long version;

    public Group() { }

    public Group(Employee groupLeader, Long version) {
        setGroupLeader(groupLeader);
        setVersion(version);
    }

    public Group(BigDecimal id, Employee groupLeader, Long version) {
        this.id = id;
        this.groupLeader = groupLeader;
        this.version = version;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        EntityValidator.validateVersion(version);
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id)
                && Objects.equals(groupLeader, group.groupLeader)
                && Objects.equals(version, group.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupLeader, version);
    }
}
