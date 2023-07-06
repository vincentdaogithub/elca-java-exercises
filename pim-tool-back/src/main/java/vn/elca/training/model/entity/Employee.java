package vn.elca.training.model.entity;

import vn.elca.training.model.validator.EntityValidator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "employee", cascade = { CascadeType.REMOVE }, orphanRemoval = true)
    private List<ProjectEmployee> projectEmployees;

    @Version
    @Column(nullable = false, length = 10)
    private Long version;

    public Employee() { }

    public Employee(String visa, EmployeeDetail employeeDetail, Long version) {
        setVisa(visa);
        setEmployeeDetail(employeeDetail);
        setVersion(version);
    }

    public Employee(BigDecimal id, String visa, EmployeeDetail employeeDetail, Long version) {
        this.id = id;
        this.visa = visa;
        this.employeeDetail = employeeDetail;
        this.version = version;
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

    public List<ProjectEmployee> getProjectEmployees() {
        return projectEmployees;
    }

    public void setProjectEmployees(List<ProjectEmployee> projectEmployees) {
        this.projectEmployees = projectEmployees;
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
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id)
                && Objects.equals(visa, employee.visa)
                && Objects.equals(employeeDetail, employee.employeeDetail)
                && Objects.equals(version, employee.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visa, employeeDetail, version);
    }
}
