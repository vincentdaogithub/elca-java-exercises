package vn.elca.training.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import vn.elca.training.service.ProjectService;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void givenProjectController_whenCallGetAllProjects_thenReturnProjectList() throws Exception {
        when(projectService.getAllProjects()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/projects/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void givenProjectController_whenCallCountProjects_thenReturnProjectListSize() throws Exception {
        when(projectService.countAllProjects()).thenReturn(5L);

        mockMvc.perform(get("/projects/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber())
                .andExpect(jsonPath("$").value(5L));
    }
}
