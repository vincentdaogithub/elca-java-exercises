package vn.elca.training.model.entity;

import vn.elca.training.model.constant_value.ProjectStatus;
import vn.elca.training.model.converter.ProjectStatusConverter;
import vn.elca.training.model.validator.EntityValidator;

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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @Column(nullable = false, unique = true, precision = 4)
    private Integer projectNumber;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String customer;

    @Column(nullable = false, length = 3)
    @Convert(converter = ProjectStatusConverter.class)
    private ProjectStatus status;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<ProjectEmployee> projectEmployees;

    @Version
    @Column(nullable = false, precision = 10)
    private Long version;

    public Project() { }

    public Project(BigDecimal id, Group group, Integer projectNumber, String name, String customer,
                   ProjectStatus status, Date startDate, Date endDate, Set<ProjectEmployee> projectEmployees,
                   Long version) {
        setId(id);
        setGroup(group);
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        EntityValidator.validateNotNull(group, "group");
        this.group = group;
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
        EntityValidator.validateString(customer, "customer", 50);
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
