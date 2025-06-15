package kg.mega.kindergarten.services.impl;


import kg.mega.kindergarten.exceptions.NotFoundException;
import kg.mega.kindergarten.exceptions.OperationNotAllowedException;
import kg.mega.kindergarten.models.*;
import kg.mega.kindergarten.repositories.*;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


@Service
public class GroupServiceImpl implements GroupService {

    private static final int MAX_CHILDREN_PER_GROUP = 20;
    public final ChildRepo childRepo;
    public final AgeGroupRepo ageGroupRepo;
    public final AssistantRepo assistantRepo;
    public final TeacherRepo teacherRepo;
    public final GroupRepo groupRepo;

    public GroupServiceImpl(ChildRepo childRepo, AgeGroupRepo ageGroupRepo, AssistantRepo assistantRepo, TeacherRepo teacherRepo, GroupRepo groupRepo) {
        this.childRepo = childRepo;
        this.ageGroupRepo = ageGroupRepo;
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

    @Override
    public ResponseEntity<?> addChildToGroup(Long groupId, UUID childId) {
        Group group = (Group) groupRepo.findByIdAndActiveIsTrue(groupId).orElseThrow(() -> new NotFoundException("Не найдена активная группа с ID: " + groupId));

        Child child = childRepo.findByIdAndActiveIsTrue(childId).orElseThrow(() -> new NotFoundException("Не найден активный ребенок с ID: " + childId));

        if (child.getGroup() != null) {
            if (child.getGroup().getId().equals(groupId)) {
                throw new OperationNotAllowedException("Ребенок уже числится в этой группе.");
            } else {
                throw new OperationNotAllowedException("Ребенок уже числится в другой активной группе с ID: " + child.getGroup().getId());
            }
        }

        long currentChildrenCount = childRepo.countByGroupIdAndActiveIsTrue(groupId);
        if (currentChildrenCount >= MAX_CHILDREN_PER_GROUP) {
            throw new OperationNotAllowedException("Превышен лимит детей в группе. Текущее количество: " + currentChildrenCount + ", Лимит: " + MAX_CHILDREN_PER_GROUP);
        }

        child.setGroup(group);
        childRepo.save(child);

        return ResponseEntity.ok().build();
    }
}
