package vn.elca.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.elca.training.model.dto.GroupDto;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.service.GroupService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/groups")
public class GroupController extends AbstractController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<GroupDto>> getAllProjectsAsDto() {
        return new ResponseEntity<>(
                groupService.getAllGroups()
                        .stream()
                        .map(EntityMapper::mapGroupToGroupDto)
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
}
