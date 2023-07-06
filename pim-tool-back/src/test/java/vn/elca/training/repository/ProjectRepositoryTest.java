package vn.elca.training.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.model.constant_value.ProjectStatus;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.util.DateUtils;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = { ProjectRepository.class })
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void givenProjectRepositoryTest_whenStartTheWholeTest_thenTheClassIsSetUp() {
        assertThat(entityManager).isNotNull();
        assertThat(projectRepository).isNotNull();
    }

    @Test
    void givenProjectRepository_whenFirstUse_thenTotalProjectCountEquals5() {
        assertThat(projectRepository.countAllProjects()).isEqualTo(5);
    }

    @Test
    void givenProjectRepository_whenFirstUse_thenProjectListHasSizeOf5() {
        assertThat(projectRepository.getAllProjects()).hasSize(5);
    }

    @Test
    void givenProjectRepository_whenAddNewProject_thenProjectListHasNewProject() {
        Long originalProjectRepositorySize = projectRepository.countAllProjects();
        Group group = entityManager.find(Group.class, BigDecimal.ONE);
        Project project = new Project(
                group,
                1,
                "name",
                "customer",
                ProjectStatus.NEW,
                DateUtils.getCurrentDateUTC0(),
                null,
                0L);
        Project addedProject = projectRepository.addNewProject(project);

        assertThat(addedProject).isNotNull();
        assertThat(projectRepository.countAllProjects()).isEqualTo(originalProjectRepositorySize + 1);

        entityManager.remove(addedProject);
        assertThat(projectRepository.countAllProjects()).isEqualTo(originalProjectRepositorySize);
    }

    @Test
    void givenProjectRepository_whenGetProjectById_thenReturnProject() {
        Project expectedProject = entityManager.find(Project.class, BigDecimal.ONE);
        Project actualProject = projectRepository.getProjectById(BigDecimal.ONE);

        assertThat(actualProject).isNotNull().isEqualTo(expectedProject);
    }
}
