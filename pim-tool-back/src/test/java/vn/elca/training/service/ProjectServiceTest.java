package vn.elca.training.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.model.constant_value.ProjectStatus;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.util.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProjectServiceTest {

    @MockBean
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @AfterEach
    void resetProjectRepository() {
        reset(projectRepository);
    }

    @Test
    void givenProjectServiceTest_whenInit_thenAllFieldsAreInitiated() {
        assertThat(projectRepository).isNotNull();
        assertThat(projectService).isNotNull();
    }

    @Test
    void givenProjectService_whenGetAllProjects_thenReturnListOfProjects() {
        when(projectRepository.getAllProjects()).thenReturn(new ArrayList<>());
        List<Project> projectListFromRepository = projectRepository.getAllProjects();

        assertThat(projectService.getAllProjects())
                .hasSameSizeAs(projectListFromRepository);
    }

    @Test
    void givenProjectService_whenCountProjects_thenReturnProjectListSize() {
        when(projectRepository.countAllProjects()).thenReturn(5L);
        Long projectListSizeFromRepository = projectRepository.countAllProjects();

        assertThat(projectService.countAllProjects()).isEqualTo(projectListSizeFromRepository);
    }

    @Test
    void givenProjectService_whenAddNewProject_thenReturnAddedProject() {
        Project expectedProject = new Project(
                BigDecimal.ONE,
                new Group(BigDecimal.ONE, null, 0L),
                1,
                "name",
                "customer",
                ProjectStatus.NEW,
                DateUtils.getCurrentDateUTC0(),
                null,
                0L);
        when(projectRepository.addNewProject(any(Project.class))).thenReturn(expectedProject);
        Project actualProject = projectRepository.addNewProject(new Project());

        assertThat(actualProject).isEqualTo(expectedProject);
    }

    @Test
    void givenProjectService_whenUpdateProject_thenReturnUpdatedProject() {
        Project expectedProject = new Project(
                BigDecimal.ONE,
                new Group(BigDecimal.ONE, null, 0L),
                1,
                "name",
                "customer",
                ProjectStatus.NEW,
                DateUtils.getCurrentDateUTC0(),
                null,
                0L);
        when(projectRepository.updateProject(any(Project.class))).thenReturn(expectedProject);
        Project actualProject = projectRepository.updateProject(new Project());

        assertThat(actualProject).isEqualTo(expectedProject);
    }
}
