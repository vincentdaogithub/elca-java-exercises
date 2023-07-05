package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.exception.NullOrBlankFieldException;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.repository.EmployeeRepository;
import vn.elca.training.repository.GroupRepository;
import vn.elca.training.repository.ProjectEmployeeRepository;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.service.ProjectService;
import vn.elca.training.service.custom.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractService implements ProjectService {

    private final ProjectRepository projectRepository;
    private final GroupRepository groupRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectEmployeeRepository projectEmployeeRepository;

    @Autowired
    public ProjectServiceImpl(
            EntityMapper entityMapper,
            ProjectRepository projectRepository,
            GroupRepository groupRepository,
            EmployeeRepository employeeRepository,
            ProjectEmployeeRepository projectEmployeeRepository) {
        super(entityMapper);
        this.projectRepository = projectRepository;
        this.groupRepository = groupRepository;
        this.employeeRepository = employeeRepository;
        this.projectEmployeeRepository = projectEmployeeRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<ProjectDto> getAllProjects() {
        return projectRepository.getAllProjects()
                .stream()
                .map(entityMapper::mapProjectToProjectDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Long countAllProjects() {
        return projectRepository.countAllProjects();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Project addNewProject(ProjectUpdateDto projectToAdd) {
        Group group = groupRepository.getGroupById(projectToAdd.getGroupId());
        Project project = entityMapper.mapProjectUpdateDtoToProject(projectToAdd, group);
        Project newProject = projectRepository.addNewProject(project);
        projectToAdd.getMembers()
                .forEach(m -> projectEmployeeRepository.addNewProjectEmployee(
                        newProject, employeeRepository.getEmployeeById(m)));
        return newProject;
    }
}
