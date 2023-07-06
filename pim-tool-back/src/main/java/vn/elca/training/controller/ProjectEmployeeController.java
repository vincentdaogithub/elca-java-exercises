package vn.elca.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.elca.training.model.dto.ProjectEmployeeDto;
import vn.elca.training.service.ProjectEmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/pim-api/project-employees")
public class ProjectEmployeeController extends AbstractController {

    private final ProjectEmployeeService projectEmployeeService;

    @Autowired
    public ProjectEmployeeController(ProjectEmployeeService projectEmployeeService) {
        this.projectEmployeeService = projectEmployeeService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ProjectEmployeeDto>> getAllProjects() {
        return new ResponseEntity<>(
                projectEmployeeService.getAllProjectEmployees(), HttpStatus.OK);
    }
}
