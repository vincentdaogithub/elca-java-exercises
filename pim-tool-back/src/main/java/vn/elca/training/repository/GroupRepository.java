package vn.elca.training.repository;

import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Group;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GroupRepository {

    List<Group> getAllGroups();

    Long countAllGroups();

    Group getGroupById(BigDecimal id);
}
