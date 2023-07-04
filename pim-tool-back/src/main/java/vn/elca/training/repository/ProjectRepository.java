package vn.elca.training.repository;

import vn.elca.training.model.entity.Project;

import java.util.List;

public interface ProjectRepository {

    List<Project> getAllProjects();

    Long countAllProjects();
}
