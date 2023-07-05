package vn.elca.training.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Group;
import vn.elca.training.model.entity.QGroup;
import vn.elca.training.repository.GroupRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    private final EntityManager entityManager;
    private static final QGroup group = QGroup.group;

    @Autowired
    public GroupRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Group> getAllGroups() {
        return new JPAQuery<Group>(entityManager)
                .from(group)
                .fetch();
    }

    @Override
    public Long countAllGroups() {
        return new JPAQuery<Group>(entityManager)
                .from(group)
                .fetchCount();
    }

    @Override
    public Group getGroupById(BigDecimal id) {
        return new JPAQuery<Group>(entityManager)
                .from(group)
                .where(group.id.eq(id))
                .fetchOne();
    }
}
