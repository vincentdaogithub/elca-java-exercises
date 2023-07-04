package vn.elca.training.service;

import vn.elca.training.model.entity.ProjectEmployee;

import java.util.List;

public interface ProjectEmployeeService {

    List<ProjectEmployee> getAllProjectEmployees();

    Long countAllProjectEmployees();
}
