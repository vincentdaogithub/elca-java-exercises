package vn.elca.training.model.mapper;

import org.springframework.stereotype.Component;
import vn.elca.training.model.dto.*;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;

import java.math.BigDecimal;

@Component
public class EntityMapper {

    public ProjectDto mapProjectToProjectDto(Project project) {
        ProjectDto projectDto =  new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setProjectNumber(project.getProjectNumber());
        projectDto.setProjectName(project.getName());
        projectDto.setCustomer(project.getCustomer());
        projectDto.setGroupLeaderVisa(project.getGroup().getGroupLeader().getVisa());
        projectDto.setStatus(project.getStatus().getStatus());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setEndDate(project.getEndDate());
        return projectDto;
    }

    public ProjectEmployeeDto mapProjectEmployeeToProjectEmployeeDto(ProjectEmployee projectEmployee) {
        ProjectEmployeeDto projectEmployeeDto = new ProjectEmployeeDto();
        projectEmployeeDto.setId(projectEmployee.getId());
        projectEmployeeDto.setProjectNumber(projectEmployee.getProject().getProjectNumber());
        projectEmployeeDto.setEmployeeVisa(projectEmployee.getEmployee().getVisa());
        return projectEmployeeDto;
    }

    public EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setVisa(employee.getVisa());
        employeeDto.setFirstName(employee.getEmployeeDetail().getFirstName());
        employeeDto.setLastName(employee.getEmployeeDetail().getLastName());
        employeeDto.setBirthDate(employee.getEmployeeDetail().getBirthDate());
        return employeeDto;
    }

    public GroupDto mapGroupToGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupLeaderVisa(group.getGroupLeader().getVisa());
        return groupDto;
    }

    public Project mapProjectUpdateDtoToProject(
            ProjectUpdateDto projectUpdateDto,
            Group group) {
        Project project = new Project();
        project.setId(BigDecimal.ZERO);
        project.setGroup(group);
        project.setProjectNumber(projectUpdateDto.getProjectNumber());
        project.setName(projectUpdateDto.getProjectName());
        project.setCustomer(projectUpdateDto.getCustomer());
        project.setStatus(projectUpdateDto.getStatus());
        project.setStartDate(projectUpdateDto.getStartDate());
        project.setEndDate(projectUpdateDto.getEndDate());
        project.setVersion(0L);
        return project;
    }
}
