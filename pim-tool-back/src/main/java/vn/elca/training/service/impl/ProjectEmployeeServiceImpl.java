package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.model.entity.ProjectEmployee;
import vn.elca.training.repository.ProjectEmployeeRepository;
import vn.elca.training.service.ProjectEmployeeService;

import java.util.List;

@Service
public class ProjectEmployeeServiceImpl implements ProjectEmployeeService {

    private final ProjectEmployeeRepository projectEmployeeRepository;

    @Autowired
    public ProjectEmployeeServiceImpl(ProjectEmployeeRepository projectEmployeeRepository) {
        this.projectEmployeeRepository = projectEmployeeRepository;
    }

    @Override
    public List<ProjectEmployee> getAllProjectEmployees() {
        return projectEmployeeRepository.getAllProjectEmployees();
    }

    @Override
    public Long countAllProjectEmployees() {
        return projectEmployeeRepository.countAllProjectEmployees();
    }
}
