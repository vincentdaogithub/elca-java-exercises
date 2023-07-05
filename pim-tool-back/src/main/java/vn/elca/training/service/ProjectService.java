package vn.elca.training.service;

import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;
import vn.elca.training.model.entity.Project;

import java.util.List;

public interface ProjectService {

    List<ProjectDto> getAllProjects();

    Long countAllProjects();

    Project addNewProject(ProjectUpdateDto projectToAdd);
}
