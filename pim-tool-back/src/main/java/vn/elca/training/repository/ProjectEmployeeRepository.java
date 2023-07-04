package vn.elca.training.repository;

import vn.elca.training.model.entity.ProjectEmployee;

import java.util.List;

public interface ProjectEmployeeRepository {

    List<ProjectEmployee> getAllProjectEmployees();

    Long countAllProjectEmployees();
}
