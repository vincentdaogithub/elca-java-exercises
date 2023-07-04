package vn.elca.training.service;

import vn.elca.training.model.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Long countAllProjects();
}
