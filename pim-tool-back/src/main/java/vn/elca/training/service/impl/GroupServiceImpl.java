package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.model.dto.GroupDto;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.repository.GroupRepository;
import vn.elca.training.service.GroupService;
import vn.elca.training.service.custom.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl extends AbstractService implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(EntityMapper entityMapper, GroupRepository groupRepository) {
        super(entityMapper);
        this.groupRepository = groupRepository;
    }

    @Override
    public List<GroupDto> getAllGroups() {
        return groupRepository.getAllGroups()
                .stream()
                .map(entityMapper::mapGroupToGroupDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long countAllGroups() {
        return groupRepository.countAllGroups();
    }
}
