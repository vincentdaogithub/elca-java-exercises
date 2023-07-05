package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.model.dto.ProjectEmployeeDto;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.repository.ProjectEmployeeRepository;
import vn.elca.training.service.ProjectEmployeeService;
import vn.elca.training.service.custom.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectEmployeeServiceImpl extends AbstractService implements ProjectEmployeeService {

    private final ProjectEmployeeRepository projectEmployeeRepository;

    @Autowired
    public ProjectEmployeeServiceImpl(EntityMapper entityMapper, ProjectEmployeeRepository projectEmployeeRepository) {
        super(entityMapper);
        this.projectEmployeeRepository = projectEmployeeRepository;
    }

    @Override
    public List<ProjectEmployeeDto> getAllProjectEmployees() {
        return projectEmployeeRepository.getAllProjectEmployees()
                .stream()
                .map(entityMapper::mapProjectEmployeeToProjectEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long countAllProjectEmployees() {
        return projectEmployeeRepository.countAllProjectEmployees();
    }
}
