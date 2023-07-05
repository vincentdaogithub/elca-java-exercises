package vn.elca.training.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.elca.training.model.entity.Project;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.repository.impl.ProjectRepositoryImpl;
import vn.elca.training.service.impl.ProjectServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    private final ProjectRepository projectRepository;
    private final ProjectService projectService;

    public ProjectServiceTest() {
        projectRepository = mock(ProjectRepositoryImpl.class);
        projectService = new ProjectServiceImpl(projectRepository);
    }

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
                .isEqualTo(projectListFromRepository)
                .hasSameSizeAs(projectListFromRepository);
    }

    @Test
    void givenProjectService_whenCountProjects_thenReturnProjectListSize() {
        when(projectRepository.countAllProjects()).thenReturn(5L);
        Long projectListSizeFromRepository = projectRepository.countAllProjects();

        assertThat(projectService.countAllProjects())
                .isEqualTo(projectListSizeFromRepository);
    }
}
