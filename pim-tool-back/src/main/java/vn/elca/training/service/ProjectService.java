package vn.elca.training.service;

import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;

import java.util.List;

public interface ProjectService {

    List<ProjectDto> getAllProjects();

    Long countAllProjects();

    ProjectDto addNewProject(ProjectUpdateDto projectToAdd);

    ProjectDto updateProject(ProjectUpdateDto projectToUpdate);
}
