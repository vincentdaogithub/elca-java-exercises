package vn.elca.training.repository;

import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProjectEmployeeRepository {

    List<ProjectEmployee> getAllProjectEmployees();

    Long countAllProjectEmployees();

    ProjectEmployee addNewProjectEmployee(ProjectEmployee projectEmployeeToAdd);

    ProjectEmployee getProjectEmployeeByProjectIdAndEmployeeId(BigDecimal projectId, BigDecimal employeeId);

    List<ProjectEmployee> updateProjectEmployees(Project projectToUpdate, List<Employee> employeesToUpdate);

    ProjectEmployee getProjectEmployeeById(BigDecimal id);
}
