package vn.elca.training.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import vn.elca.training.entity.exception.FieldOutOfRangeException;
import vn.elca.training.entity.exception.NullOrBlankFieldException;
import vn.elca.training.entity.validator.EntityValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 19)
    private BigDecimal id;

    @Column(nullable = false, length = 3)
    private String visa;

    @Embedded
    private EmployeeDetail employeeDetail;      // already Serializable

    @Transient
    @OneToOne(mappedBy = "leader")
    private Team team;      // already Transient

    @Transient
    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<ProjectEmployee> projectEmployees;      // already Transient

    @Version
    @Column(nullable = false, length = 10)
    private Long version;

    public Employee() { }

    public Employee(BigDecimal id, String visa, EmployeeDetail employeeDetail, Team team,
                    Set<ProjectEmployee> projectEmployees, Long version) {
        setId(id);
        setVisa(visa);
        setEmployeeDetail(employeeDetail);
        this.team = team;
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

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        EntityValidator.validateString(visa, "visa", 3);
        this.visa = visa;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        EntityValidator.validateNotNull(employeeDetail, "employeeDetail");
        this.employeeDetail = employeeDetail;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
