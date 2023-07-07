package vn.elca.training.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import vn.elca.training.model.constant_value.ProjectStatus;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;
import vn.elca.training.service.ProjectService;
import vn.elca.training.util.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {ProjectController.class})
@ExtendWith(SpringExtension.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @AfterEach
    void cleanUpProjectService() {
        reset(projectService);
    }

    @Test
    void givenProjectControllerTest_whenInit_thenAllFieldsExist() {
        assertThat(mockMvc).isNotNull();
        assertThat(projectService).isNotNull();
    }

    @Test
    void givenProjectController_whenGetAllProjects_thenReturnProjectList() throws Exception {
        when(projectService.getAllProjects()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/pim-api/projects/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void givenProjectController_whenGetCountProjects_thenReturnProjectListSize() throws Exception {
        when(projectService.countAllProjects()).thenReturn(5L);

        mockMvc.perform(get("/pim-api/projects/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(5L));
    }

    @Test
    void givenProjectController_whenPostNewProject_thenReturnAddedProject() throws Exception {
        ProjectDto resultProject = new ProjectDto(
                BigDecimal.ONE,
                1,
                "name",
                "customer",
                ProjectStatus.NEW.getStatus(),
                DateUtils.getCurrentDateUTC0(),
                null);
        when(projectService.addNewProject(any(ProjectUpdateDto.class))).thenReturn(resultProject);
        assertThat(projectService.addNewProject(new ProjectUpdateDto())).isEqualTo(resultProject);

        ObjectMapper objectMapper = new ObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String requestBody = objectMapper.writeValueAsString(new ProjectUpdateDto());
        String responseBody = objectMapper.writeValueAsString(resultProject);
        mockMvc.perform(post("/pim-api/projects/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string(responseBody));
    }

    @Test
    void givenProjectController_whenPutProjectToUpdate_thenReturnUpdatedProject() throws Exception {
        ProjectDto resultProject = new ProjectDto(
                BigDecimal.ONE,
                1,
                "name",
                "customer",
                ProjectStatus.NEW.getStatus(),
                DateUtils.getCurrentDateUTC0(),
                null);
        when(projectService.updateProject(any(ProjectUpdateDto.class))).thenReturn(resultProject);
        assertThat(projectService.updateProject(new ProjectUpdateDto())).isEqualTo(resultProject);

        ObjectMapper objectMapper = new ObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String requestBody = objectMapper.writeValueAsString(new ProjectUpdateDto());
        String responseBody = objectMapper.writeValueAsString(resultProject);
        mockMvc.perform(put("/pim-api/projects/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string(responseBody));
    }

    @Test
    void givenProjectController_whenDeleteProjectIdToRemove_thenRemoveIt() throws Exception {
        assertThatCode(() -> {
            projectService.removeProject(BigDecimal.ONE);
        }).doesNotThrowAnyException();

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(delete("/pim-api/projects/remove")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(BigDecimal.valueOf(1))))
                .andExpect(status().isOk())
                .andExpect(content().string("Removed successfully"));
    }

    @Test
    void givenProjectController_whenDeleteProjectIdsToRemove_thenRemoveAllOfThem() throws Exception {
        List<BigDecimal> projectIdsToRemove = new ArrayList<>();
        projectIdsToRemove.add(BigDecimal.valueOf(1));
        projectIdsToRemove.add(BigDecimal.valueOf(2));
        projectIdsToRemove.add(BigDecimal.valueOf(3));

        assertThatCode(() -> {
            projectService.removeProjects(projectIdsToRemove);
        }).doesNotThrowAnyException();

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(delete("/pim-api/projects/remove")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectIdsToRemove)))
                .andExpect(status().isOk())
                .andExpect(content().string("Removed successfully"));
    }
}
