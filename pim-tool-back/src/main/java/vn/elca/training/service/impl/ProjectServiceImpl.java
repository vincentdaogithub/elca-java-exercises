package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectUpdateDto;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.repository.EmployeeRepository;
import vn.elca.training.repository.GroupRepository;
import vn.elca.training.repository.ProjectEmployeeRepository;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.service.ProjectService;
import vn.elca.training.service.custom.AbstractService;

import java.math.BigDecimal;
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
    public ProjectDto addNewProject(ProjectUpdateDto projectToAdd) {
        Group groupToAdd = groupRepository.getGroupById(projectToAdd.getGroupId());
        Project project = entityMapper.mapProjectUpdateDtoToProject(projectToAdd, groupToAdd);
        Project newProject = projectRepository.addNewProject(project);
        projectToAdd.getMembers()
                .forEach(m -> {
                    ProjectEmployee newProjectEmployee = new ProjectEmployee(
                            newProject,
                            employeeRepository.getEmployeeById(m));
                    projectEmployeeRepository.addNewProjectEmployee(newProjectEmployee);
                });
        return entityMapper.mapProjectToProjectDto(newProject);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ProjectDto updateProject(ProjectUpdateDto projectToUpdate) {
        Group groupToUpdate = groupRepository.getGroupById(projectToUpdate.getGroupId());
        Project project = entityMapper.mapProjectUpdateDtoToProject(projectToUpdate, groupToUpdate);
        Project updatedProject = projectRepository.updateProject(project);
        projectEmployeeRepository.updateProjectEmployees(
                updatedProject,
                projectToUpdate.getMembers()
                        .stream()
                        .map(employeeRepository::getEmployeeById)
                        .collect(Collectors.toList()));
        return entityMapper.mapProjectToProjectDto(updatedProject);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void removeProject(BigDecimal projectIdToRemove) {
        projectEmployeeRepository.removeProjectEmployeesByProjectId(projectIdToRemove);
        projectRepository.removeProject(projectIdToRemove);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void removeProjects(List<BigDecimal> projectIdsToRemove) {
        projectIdsToRemove.forEach(projectEmployeeRepository::removeProjectEmployeesByProjectId);
        projectRepository.removeProjects(projectIdsToRemove);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean checkIfProjectNumberExist(Integer projectNumber) {
        return projectRepository.getProjectByProjectNumber(projectNumber) != null;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ProjectUpdateDto getProjectByProjectNumber(Integer projectNumber) {
        Project result = projectRepository.getProjectByProjectNumber(projectNumber);
        if (result == null) {
            return null;
        }
        return entityMapper.mapProjectToProjectUpdateDto(result);
    }
}
