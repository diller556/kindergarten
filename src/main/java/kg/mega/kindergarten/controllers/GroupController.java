package kg.mega.kindergarten.controllers;

import jakarta.validation.Valid;
import kg.mega.kindergarten.models.dto.*;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController implements CRUDOperations<GroupDto, GroupCreateDto> {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/{groupId}/assign-teacher")
    public ResponseEntity<?> assignTeacherToGroup(
            @PathVariable Long groupId,
            @RequestBody AssignTeacherRequest request) {
        return groupService.assignTeacherToGroup(groupId, request.getTeacherId());
        //http://localhost:8080/api/v1/group/1/assign-teacher
    }


    @PostMapping("/{groupId}/assign-assistant")
    public ResponseEntity<?> assignAssistantToGroup(
            @PathVariable Long groupId,
            @RequestBody AssignAssistantRequest request) {
        return groupService.assignAssistantToGroup(groupId, request.getAssistantId());
    }

    @PostMapping("/{groupId}/add-child")
    public ResponseEntity<?> addChildToGroup(
            @PathVariable Long groupId,
            @Valid @RequestBody AddChildRequest request) {
        return groupService.addChildToGroup(groupId, request.getChildId());
    }

    @Override
    public GroupDto create(GroupDto groupDto) {
        return null;
    }

    @Override
    public GroupDto read(GroupCreateDto groupCreateDto) {
        return null;
    }

    @Override
    public List<GroupDto> readAll(int page, int size) {
        return List.of();
    }

    @Override
    public GroupDto update(GroupDto groupDto) {
        return null;
    }

    @Override
    public boolean delete(GroupCreateDto groupCreateDto) {
        return false;
    }
}
