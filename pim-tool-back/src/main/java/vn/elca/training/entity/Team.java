package vn.elca.training.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import vn.elca.training.entity.validator.EntityValidator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 19)
    private BigDecimal id;

    @OneToOne(optional = false)
    @JoinColumn(name = "team_leader_id")
    private Employee leader;

    @Transient
    @OneToMany(mappedBy = "team")
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Project> projects;

    @Version
    @Column(nullable = false)
    private Long version;

    public Team() { }

    public Team(BigDecimal id, Employee leader, Set<Project> projects, Long version) {
        setId(id);
        setLeader(leader);
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

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        EntityValidator.validateNotNull(leader, "leader");
        this.leader = leader;
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
