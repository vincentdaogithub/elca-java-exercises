package vn.elca.training.repository;

import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Project;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProjectRepository {

    List<Project> getAllProjects();

    Long countAllProjects();

    Project addNewProject(Project projectToAdd);

    Project getProjectById(BigDecimal id);
}
