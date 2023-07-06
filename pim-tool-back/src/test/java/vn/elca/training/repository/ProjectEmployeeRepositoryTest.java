package vn.elca.training.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = { ProjectEmployeeRepository.class })
class ProjectEmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectEmployeeRepository projectEmployeeRepository;

    @Test
    void givenProjectEmployeeRepositoryTest_whenInit_thenAllFieldsExist() {
        assertThat(entityManager).isNotNull();
        assertThat(projectEmployeeRepository).isNotNull();
    }

    @Test
    void givenProjectEmployeeRepository_whenGetProjectEmployeeByProjectIdAndEmployeeId_thenReturnProjectEmployee() {
        ProjectEmployee expectedProjectEmployee = entityManager.find(ProjectEmployee.class, BigDecimal.ONE);
        ProjectEmployee actualProjectEmployee = projectEmployeeRepository
                .getProjectEmployeeByProjectIdAndEmployeeId(
                        expectedProjectEmployee.getProject().getId(),
                        expectedProjectEmployee.getEmployee().getId());

        assertThat(actualProjectEmployee).isNotNull().isEqualTo(expectedProjectEmployee);
    }

    @Test
    void givenProjectEmployeeRepository_whenAddNewProjectEmployee_thenProjectEmployeeAdded() {
        Long originalProjectEmployeeRepositorySize = projectEmployeeRepository.countAllProjectEmployees();
        Project projectTest = entityManager.find(Project.class, BigDecimal.ONE);
        Employee employeeTest = entityManager.find(Employee.class, new BigDecimal(18));

        ProjectEmployee newProjectEmployee = new ProjectEmployee(
                projectTest,
                employeeTest);
        ProjectEmployee addedProjectEmployee = projectEmployeeRepository
                .addNewProjectEmployee(newProjectEmployee);

        assertThat(addedProjectEmployee).isNotNull();
        assertThat(projectEmployeeRepository.countAllProjectEmployees())
                .isEqualTo(originalProjectEmployeeRepositorySize + 1);

        entityManager.remove(addedProjectEmployee);
        assertThat(projectEmployeeRepository.countAllProjectEmployees())
                .isEqualTo(originalProjectEmployeeRepositorySize);
    }
}
