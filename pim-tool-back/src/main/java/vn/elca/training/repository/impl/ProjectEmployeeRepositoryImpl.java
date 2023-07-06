package vn.elca.training.repository.impl;

import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;
import vn.elca.training.model.entity.QProjectEmployee;
import vn.elca.training.repository.ProjectEmployeeRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectEmployeeRepositoryImpl implements ProjectEmployeeRepository {

    private final EntityManager entityManager;
    private static final QProjectEmployee projectEmployee = QProjectEmployee.projectEmployee;

    @Autowired
    public ProjectEmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProjectEmployee> getAllProjectEmployees() {
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .fetch();
    }

    @Override
    public Long countAllProjectEmployees() {
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .fetchCount();
    }

    @Override
    public ProjectEmployee addNewProjectEmployee(ProjectEmployee projectEmployeeToAdd) {
        entityManager.persist(projectEmployeeToAdd);
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .where(projectEmployee.project.id.eq(projectEmployeeToAdd.getProject().getId())
                        .and(projectEmployee.employee.id.eq(projectEmployeeToAdd.getEmployee().getId())))
                .fetchOne();
    }

    @Override
    public ProjectEmployee getProjectEmployeeByProjectIdAndEmployeeId(BigDecimal projectId, BigDecimal employeeId) {
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .where(projectEmployee.project.id.eq(projectId).and(projectEmployee.employee.id.eq(employeeId)))
                .fetchOne();
    }

    @Override
    public List<ProjectEmployee> updateProjectEmployees(Project projectToUpdate, List<Employee> employeesToUpdate) {
        new JPADeleteClause(entityManager, projectEmployee).where(projectEmployee.project.eq(projectToUpdate)).execute();
        List<ProjectEmployee> updatedProjectEmployees = new ArrayList<>();
        employeesToUpdate.forEach(e -> {
            ProjectEmployee projectEmployeeToAdd = new ProjectEmployee(projectToUpdate, e);
            updatedProjectEmployees.add(addNewProjectEmployee(projectEmployeeToAdd));
        });
        return updatedProjectEmployees;
    }

    @Override
    public ProjectEmployee getProjectEmployeeById(BigDecimal id) {
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .where(projectEmployee.id.eq(id))
                .fetchOne();
    }
}
