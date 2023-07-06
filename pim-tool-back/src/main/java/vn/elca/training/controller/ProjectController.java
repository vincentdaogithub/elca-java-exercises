package vn.elca.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;
import vn.elca.training.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping(path = "/pim-api/projects")
public class ProjectController extends AbstractController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ProjectDto>> getAllProjectsAsDto() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> countAllProjects() {
        return new ResponseEntity<>(projectService.countAllProjects(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ProjectDto> addNewProject(
            @RequestBody ProjectUpdateDto projectToAdd) {
        return new ResponseEntity<>(projectService.addNewProject(projectToAdd), HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<ProjectDto> updateProject(
            @RequestBody ProjectUpdateDto projectToUpdate) {
        return new ResponseEntity<>(projectService.updateProject(projectToUpdate), HttpStatus.OK);
    }
}
