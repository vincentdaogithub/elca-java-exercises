package vn.elca.training.model.entity;

import vn.elca.training.model.validator.EntityValidator;

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

    @Column(nullable = false, unique = true, length = 3)
    private String visa;

    @Embedded
    private EmployeeDetail employeeDetail;

    @OneToOne(mappedBy = "groupLeader")
    private Group group;

    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    private Set<ProjectEmployee> projectEmployees;

    @Version
    @Column(nullable = false, length = 10)
    private Long version;

    public Employee() { }

    public Employee(BigDecimal id, String visa, EmployeeDetail employeeDetail, Group group,
                    Set<ProjectEmployee> projectEmployees, Long version) {
        setId(id);
        setVisa(visa);
        setEmployeeDetail(employeeDetail);
        this.group = group;
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
        this.visa = visa.toUpperCase();
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        EntityValidator.validateNotNull(employeeDetail, "employeeDetail");
        this.employeeDetail = employeeDetail;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
