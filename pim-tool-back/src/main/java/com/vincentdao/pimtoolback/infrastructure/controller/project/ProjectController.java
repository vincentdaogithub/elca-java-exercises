/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.controller.project;

import com.vincentdao.pimtoolback.application.project.ViewProjectsWithFiltersPaginatedUseCase;
import com.vincentdao.pimtoolback.application.project.request.ViewProjectsWithFiltersPaginatedRequest;
import com.vincentdao.pimtoolback.application.project.response.ProjectResponse;
import com.vincentdao.pimtoolback.infrastructure.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/projects")
public class ProjectController implements BaseController {

    private final ViewProjectsWithFiltersPaginatedUseCase viewProjectsService;

    @Autowired
    public ProjectController(ViewProjectsWithFiltersPaginatedUseCase viewProjectsService) {
        this.viewProjectsService = viewProjectsService;
    }

    public ResponseEntity<List<ProjectResponse>> viewProjectsWithFiltersPaginated(
            @RequestBody ViewProjectsWithFiltersPaginatedRequest input) {
        return new ResponseEntity<>(viewProjectsService.getProjects(input), HttpStatus.OK);
    }
}
