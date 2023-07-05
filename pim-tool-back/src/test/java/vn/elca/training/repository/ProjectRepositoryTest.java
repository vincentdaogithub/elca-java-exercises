package vn.elca.training.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.repository.impl.ProjectRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(ProjectRepositoryImpl.class)
class ProjectRepositoryTest {

    private final TestEntityManager entityManager;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectRepositoryTest(TestEntityManager entityManager, ProjectRepository projectRepository) {
        this.entityManager = entityManager;
        this.projectRepository = projectRepository;
    }

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
}
