package vn.elca.training.service;

import vn.elca.training.model.dto.ProjectEmployeeDto;

import java.util.List;

public interface ProjectEmployeeService {

    List<ProjectEmployeeDto> getAllProjectEmployees();

    Long countAllProjectEmployees();
}
