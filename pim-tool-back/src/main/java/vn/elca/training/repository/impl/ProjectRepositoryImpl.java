package vn.elca.training.repository.impl;

import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.QProject;
import vn.elca.training.model.exception.*;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.repository.exception.*;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final EntityManager entityManager;
    private static final QProject project = QProject.project;

    @Autowired
    public ProjectRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Project> getAllProjects() {
        return new JPAQuery<Project>(entityManager)
                .from(project)
                .fetch();
    }

    @Override
    public Long countAllProjects() {
        return new JPAQuery<Project>(entityManager)
                .from(project)
                .fetchCount();
    }

    @Override
    public Project addNewProject(Project projectToAdd) {
        if (projectToAdd == null) {
            throw new NullPointerException("Null param in " + ProjectRepositoryImpl.class.getName());
        }
        Project existingProjectWithProjectNumber = new JPAQuery<Project>(entityManager)
                .from(project)
                .where(project.projectNumber.eq(projectToAdd.getProjectNumber()))
                .fetchOne();
        if (existingProjectWithProjectNumber != null) {
            throw new DuplicateProjectNumberException();
        }
        entityManager.persist(projectToAdd);
        return new JPAQuery<Project>(entityManager)
                .from(project)
                .where(project.projectNumber.eq(projectToAdd.getProjectNumber()))
                .fetchOne();
    }

    @Override
    public Project getProjectById(BigDecimal id) {
        return new JPAQuery<Project>(entityManager)
                .from(project)
                .where(project.id.eq(id))
                .fetchOne();
    }

    @Override
    public Project updateProject(Project projectToUpdate) {
        Project projectToUpdateInDatabase = new JPAQuery<Project>(entityManager)
                .from(project)
                .where(project.id.eq(projectToUpdate.getId()))
                .fetchOne();
        if (projectToUpdateInDatabase == null) {
            throw new UpdateNonExistingProjectException();
        }
        if (!projectToUpdateInDatabase.getProjectNumber()
                .equals(projectToUpdate.getProjectNumber())) {
            throw new ModifyExistingProjectNumberException();
        }
        if (!projectToUpdateInDatabase.getVersion().equals(projectToUpdate.getVersion())) {
            throw new OptimisticLockException("Concurrent update at " + ProjectRepositoryImpl.class.getName());
        }

        entityManager.flush();
        long result = new JPAUpdateClause(entityManager, project)
                .where(project.id.eq(projectToUpdate.getId()))
                .set(project.group, projectToUpdate.getGroup())
                .set(project.name, projectToUpdate.getName())
                .set(project.customer, projectToUpdate.getCustomer())
                .set(project.status, projectToUpdate.getStatus())
                .set(project.startDate, projectToUpdate.getStartDate())
                .set(project.endDate, projectToUpdate.getEndDate())
                .set(project.version, projectToUpdate.getVersion() + 1)
                .execute();
        if (result != 1) {
            throw new NoneOrMultipleProjectsUpdateException();
        }
        entityManager.clear();

        return new JPAQuery<Project>(entityManager)
                .from(project)
                .where(project.id.eq(projectToUpdate.getId()))
                .fetchOne();
    }

    @Override
    public void removeProject(BigDecimal id) {
        entityManager.flush();
        long result = new JPADeleteClause(entityManager, project)
                .where(project.id.eq(id))
                .execute();
        if (result != 1) {
            throw new NoneOrMultipleProjectsRemoveException();
        }
        entityManager.clear();
    }

    @Override
    public void removeProjects(List<BigDecimal> ids) {
        entityManager.flush();
        long result = new JPADeleteClause(entityManager, project)
                .where(project.id.in(ids))
                .execute();
        if (result < 1) {
            throw new NoProjectRemoveException();
        }
        entityManager.clear();
    }
}
