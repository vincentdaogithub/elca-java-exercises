package vn.elca.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.service.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/projects")
public class ProjectController extends AbstractController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ProjectDto>> getAllProjectsAsDto() {
        return new ResponseEntity<>(
                projectService.getAllProjects()
                        .stream()
                        .map(EntityMapper::mapProjectToProjectDto)
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
}