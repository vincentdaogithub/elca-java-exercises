package vn.elca.training.model.mapper;

import vn.elca.training.model.dto.EmployeeDto;
import vn.elca.training.model.dto.GroupDto;
import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.ProjectEmployeeDto;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.ProjectEmployee;

public class EntityMapper {

    EntityMapper() { }

    public static ProjectDto mapProjectToProjectDto(Project project) {
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

    public static ProjectEmployeeDto mapProjectEmployeeToProjectEmployeeDto(ProjectEmployee projectEmployee) {
        ProjectEmployeeDto projectEmployeeDto = new ProjectEmployeeDto();
        projectEmployeeDto.setId(projectEmployee.getId());
        projectEmployeeDto.setProjectNumber(projectEmployee.getProject().getProjectNumber());
        projectEmployeeDto.setEmployeeVisa(projectEmployee.getEmployee().getVisa());
        return projectEmployeeDto;
    }

    public static EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setVisa(employee.getVisa());
        employeeDto.setFirstName(employee.getEmployeeDetail().getFirstName());
        employeeDto.setLastName(employee.getEmployeeDetail().getLastName());
        employeeDto.setBirthDate(employee.getEmployeeDetail().getBirthDate());
        return employeeDto;
    }

    public static GroupDto mapGroupToGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupLeaderVisa(group.getGroupLeader().getVisa());
        return groupDto;
    }
}
