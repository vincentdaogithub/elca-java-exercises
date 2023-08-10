package com.vincentdao.pimtoolback.domain.project;

import com.vincentdao.pimtoolback.domain.employee.Employee;
import com.vincentdao.pimtoolback.domain.group.Group;
import com.vincentdao.pimtoolback.domain.project.exception.DeleteProjectWhileStatusIsNotNewException;
import com.vincentdao.pimtoolback.domain.project.exception.GroupLeaderExistsInProjectEmployeeListException;
import com.vincentdao.pimtoolback.domain.project.exception.ProjectNumberChangedDuringUpdateException;
import lombok.Getter;

import java.util.Collection;

@Getter
public class Project {

    private final ProjectId id;
    private final Group group;
    private final ProjectDetail projectDetail;
    private final ProjectStatus projectStatus;
    private final ProjectDuration projectDuration;
    private final Collection<Employee> projectEmployees;

    private Project(ProjectId id, Group group, ProjectDetail projectDetail, ProjectStatus projectStatus,
                   ProjectDuration projectDuration, Collection<Employee> projectEmployees) {
        this.id = id;
        this.group = group;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
        this.projectDuration = projectDuration;
        this.projectEmployees = projectEmployees;
    }

    /**
     * <p>This should be used for creating new project without id. Is used when the project is new to the database</p>
     */
    public static Project createNewWithoutId(Group group, ProjectDetail projectDetail, ProjectStatus projectStatus,
                                             ProjectDuration projectDuration, Collection<Employee> projectEmployees) {
        if (group == null || projectDetail == null || projectStatus == null || projectDuration == null
                || projectEmployees == null) {
            throw new IllegalArgumentException("Null arguments");
        }
        checkIfGroupLeaderIsInProjectEmployees(group.getGroupLeader(), projectEmployees);
        return new Project(null, group, projectDetail, projectStatus, projectDuration, projectEmployees);
    }

    /**
     * <p>This is used to create project with id. Is used for mostly mapping from database.</p>
     */
    public static Project createNew(ProjectId id, Group group, ProjectDetail projectDetail, ProjectStatus projectStatus,
                                    ProjectDuration projectDuration, Collection<Employee> projectEmployees) {
        if (id == null || group == null || projectDetail == null || projectStatus == null || projectDuration == null
                || projectEmployees == null) {
            throw new IllegalArgumentException("Null arguments");
        }
        checkIfGroupLeaderIsInProjectEmployees(group.getGroupLeader(), projectEmployees);
        return new Project(id, group, projectDetail, projectStatus, projectDuration, projectEmployees);
    }

    private static void checkIfGroupLeaderIsInProjectEmployees(Employee groupLeader,
                                                               Collection<Employee> projectEmployees) {
        if (groupLeader == null || projectEmployees == null) {
            throw new IllegalArgumentException("Null arguments");
        }
        if (projectEmployees.contains(groupLeader)) {
            throw new GroupLeaderExistsInProjectEmployeeListException(groupLeader);
        }
    }

    /**
     * <p>Call this method only to check if the project is delete-able or not. Returns nothing except exception if
     * something is wrong.</p>
     * @throws DeleteProjectWhileStatusIsNotNewException When project status is not NEW
     */
    public void deleteProject() throws DeleteProjectWhileStatusIsNotNewException {
        if (projectStatus != ProjectStatus.NEW) {
            throw new DeleteProjectWhileStatusIsNotNewException();
        }
    }

    /**
     * <p>This method is to check if the project is updatable or not. Returns nothing except exception if something is
     * wrong</p>
     * @throws IllegalArgumentException When method argument is null
     * @throws ProjectNumberChangedDuringUpdateException When the updated project has different project number compare
     * to the one being updated
     */
    public void updateProject(Project updatedProject)
            throws IllegalArgumentException, ProjectNumberChangedDuringUpdateException {
        if (updatedProject == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (!updatedProject.getProjectDetail().projectNumber().equals(this.projectDetail.projectNumber())) {
            throw new ProjectNumberChangedDuringUpdateException();
        }
    }
}
