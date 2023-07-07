package vn.elca.training.service;

import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProjectService {

    List<ProjectDto> getAllProjects();

    Long countAllProjects();

    ProjectDto addNewProject(ProjectUpdateDto projectToAdd);

    ProjectDto updateProject(ProjectUpdateDto projectToUpdate);

    void removeProject(BigDecimal projectIdToRemove);

    void removeProjects(List<BigDecimal> projectIdsToRemove);

    boolean checkIfProjectNumberExist(Integer projectNumber);

    ProjectUpdateDto getProjectByProjectNumber(Integer projectNumber);
}
