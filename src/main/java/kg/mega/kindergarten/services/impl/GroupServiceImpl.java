package kg.mega.kindergarten.services.impl;


import kg.mega.kindergarten.exceptions.NotFoundException;
import kg.mega.kindergarten.exceptions.OperationNotAllowedException;
import kg.mega.kindergarten.models.Assistant;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.repositories.AssistantRepo;
import kg.mega.kindergarten.repositories.GroupRepo;
import kg.mega.kindergarten.repositories.TeacherRepo;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GroupServiceImpl implements GroupService {

    public final AssistantRepo assistantRepo;
    public final TeacherRepo teacherRepo;
    public final GroupRepo groupRepo;

    public GroupServiceImpl(AssistantRepo assistantRepo, TeacherRepo teacherRepo, GroupRepo groupRepo) {
        this.assistantRepo = assistantRepo;
        this.teacherRepo = teacherRepo;
        this.groupRepo = groupRepo;
    }

    @Override
    public ResponseEntity<?> assignTeacherToGroup(Long groupId, Long teacherId) {
        Group group = (Group) groupRepo.findByIdAndActiveIsTrue(groupId).orElseThrow(() -> new NotFoundException("Не найдена группа с ID: " + groupId));

        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(() -> new NotFoundException("Не найден учитель с ID: " + teacherId));

        Optional<Group> teacherGroup = groupRepo.findByTeacherAndActiveIsTrue(teacher);
        if (teacherGroup.isPresent() && !teacherGroup.get().getId().equals(groupId)) {
            throw new OperationNotAllowedException("Учитель уже назначен в другую активную группу");
        }

        if (group.getTeacher() != null) {
            throw new OperationNotAllowedException("Группа уже имеет назначенного учителя");
        }

        group.setTeacher(teacher);
        groupRepo.save(group);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> assignAssistantToGroup(Long groupId, Long assistantId) {
        Group group = (Group) groupRepo.findByIdAndActiveIsTrue(groupId).orElseThrow(() -> new NotFoundException("Не найдена группа с ID: " + groupId));

        Assistant assistant = assistantRepo.findById(assistantId).orElseThrow(() -> new NotFoundException("Не найден помощник с ID: " + assistantId));

        Optional<Group> assistantGroup = groupRepo.findByAssistantAndActiveIsTrue(assistant);
        if (assistantGroup.isPresent() && !assistantGroup.get().getId().equals(groupId)) {
            throw new OperationNotAllowedException("Помощник уже назначен в другую активную группу");
        }

        if (group.getAssistant() != null) {
            throw new OperationNotAllowedException("Группа уже имеет назначенного помощника");
        }

        group.setAssistant(assistant);
        groupRepo.save(group);

        return ResponseEntity.ok().build();
    }


}
