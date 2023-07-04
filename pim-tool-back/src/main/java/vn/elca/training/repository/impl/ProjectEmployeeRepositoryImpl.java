package vn.elca.training.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.ProjectEmployee;
import vn.elca.training.model.entity.QProjectEmployee;
import vn.elca.training.repository.ProjectEmployeeRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProjectEmployeeRepositoryImpl implements ProjectEmployeeRepository {

    private final EntityManager entityManager;
    private static final QProjectEmployee projectEmployee = QProjectEmployee.projectEmployee;

    @Autowired
    public ProjectEmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProjectEmployee> getAllProjectEmployees() {
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .fetch();
    }

    @Override
    public Long countAllProjectEmployees() {
        return new JPAQuery<ProjectEmployee>(entityManager)
                .from(projectEmployee)
                .fetchCount();
    }
}
