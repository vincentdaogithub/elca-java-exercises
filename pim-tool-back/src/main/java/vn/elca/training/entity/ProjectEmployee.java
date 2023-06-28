package vn.elca.training.entity;

import vn.elca.training.entity.validator.EntityValidator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProjectEmployee {

    @Id
    @Column(precision = 19)
    private BigDecimal id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public ProjectEmployee() { }

    public ProjectEmployee(BigDecimal id, Project project, Employee employee) {
        setId(id);
        setProject(project);
        setEmployee(employee);
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        EntityValidator.validateId(id);
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        EntityValidator.validateNotNull(project, "project");
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        EntityValidator.validateNotNull(employee, "employee");
        this.employee = employee;
    }
}
