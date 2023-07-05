package vn.elca.training.repository;

import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;

import java.util.List;

@Repository
public interface ProjectEmployeeRepository {

    List<ProjectEmployee> getAllProjectEmployees();

    Long countAllProjectEmployees();

    ProjectEmployee addNewProjectEmployee(Project project, Employee employee);
}
