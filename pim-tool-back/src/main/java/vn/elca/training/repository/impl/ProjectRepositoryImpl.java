package vn.elca.training.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.QProject;
import vn.elca.training.repository.ProjectRepository;

import javax.persistence.EntityManager;
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
}
