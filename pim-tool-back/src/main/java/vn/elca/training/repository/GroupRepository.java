package vn.elca.training.repository;

import vn.elca.training.model.entity.Group;

import java.util.List;

public interface GroupRepository {

    List<Group> getAllGroups();

    Long countAllGroups();
}
