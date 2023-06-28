package vn.elca.training.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import vn.elca.training.entity.constant_value.ProjectStatus;
import vn.elca.training.entity.exception.EndDateBeforeOrEqualStartDateException;
import vn.elca.training.entity.validator.EntityValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 19)
    private BigDecimal id;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;      // already Serializable

    @Column(nullable = false, unique = true)
    private Integer projectNumber;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String customer;

    @Column(nullable = false, length = 3)
    private ProjectStatus status;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Transient
    @OneToMany(mappedBy = "project")
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<ProjectEmployee> projectEmployees;      // already transient

    @Version
    @Column(nullable = false, length = 10)
    private Long version;

    public Project() { }

    public Project(BigDecimal id, Team team, Integer projectNumber, String name, String customer,
                   ProjectStatus status, Date startDate, Date endDate, Set<ProjectEmployee> projectEmployees,
                   Long version) {
        setId(id);
        setTeam(team);
        setProjectNumber(projectNumber);
        setName(name);
        setCustomer(customer);
        setStatus(status);
        this.startDate = startDate;
        setEndDate(endDate);
        this.projectEmployees = projectEmployees;
        setVersion(version);
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        EntityValidator.validateId(id);
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        EntityValidator.validateNotNull(team, "team");
        this.team = team;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        EntityValidator.validateProjectNumber(projectNumber);
        this.projectNumber = projectNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        EntityValidator.validateString(name, "name", 50);
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        EntityValidator.validateString(name, "customer", 50);
        this.customer = customer;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        EntityValidator.validateNotNull(status, "status");
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        EntityValidator.validateNotNull(startDate, "startDate");
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        EntityValidator.validateEndDate(endDate, this.startDate);
        this.endDate = endDate;
    }

    public Set<ProjectEmployee> getProjectEmployees() {
        return projectEmployees;
    }

    public void setProjectEmployees(Set<ProjectEmployee> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        EntityValidator.validateVersion(version);
        this.version = version;
    }
}
