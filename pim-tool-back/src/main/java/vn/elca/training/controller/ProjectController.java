package vn.elca.training.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.elca.training.controller.exception.InvalidUserRequestException;
import vn.elca.training.model.converter.ProjectStatusConverter;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;
import vn.elca.training.service.ProjectService;

import javax.persistence.Convert;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    @PutMapping(path = "/update")
    @Convert(converter = ProjectStatusConverter.class)
    public ResponseEntity<ProjectDto> updateProject(
            @RequestBody ProjectUpdateDto projectToUpdate) {
        return new ResponseEntity<>(projectService.updateProject(projectToUpdate), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping(path = "/remove")
    public ResponseEntity<String> removeProject(
            @RequestBody JsonNode projectIdsToRemove) {
        if (projectIdsToRemove.isNumber()) {
            projectService.removeProject(projectIdsToRemove.decimalValue());
        } else if (projectIdsToRemove.isArray()) {
            List<BigDecimal> convertedProjectIds = new ArrayList<>();
            for (JsonNode projectIdToRemove : projectIdsToRemove) {
                if (projectIdToRemove.isNumber()) {
                    convertedProjectIds.add(projectIdToRemove.decimalValue());
                } else {
                    throw new InvalidUserRequestException();
                }
                projectService.removeProjects(convertedProjectIds);
            }
        } else {
            throw new InvalidUserRequestException();
        }
        return new ResponseEntity<>("Removed successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/check/{projectNumber}")
    @Convert(converter = ProjectStatusConverter.class)
    public ResponseEntity<Boolean> checkIfProjectNumberExists(
            @PathVariable(name = "projectNumber") Integer projectNumber) {
        return new ResponseEntity<>(projectService.checkIfProjectNumberExist(projectNumber), HttpStatus.OK);
    }

    @GetMapping(path = "/{projectNumber}")
    @Convert(converter = ProjectStatusConverter.class)
    public ResponseEntity<ProjectUpdateDto> getProjectByProjectNumber(
            @PathVariable(name = "projectNumber") Integer projectNumber) {
        ProjectUpdateDto result = projectService.getProjectByProjectNumber(projectNumber);
        return new ResponseEntity<>(result, result != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
