package kg.mega.kindergarten.services.impl;


import kg.mega.kindergarten.exceptions.NotFoundException;
import kg.mega.kindergarten.exceptions.OperationNotAllowedException;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.repositories.GroupRepo;
import kg.mega.kindergarten.repositories.TeacherRepo;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GroupServiceImpl implements GroupService {

    public final TeacherRepo teacherRepo;
    public final GroupRepo groupRepo;

    public GroupServiceImpl(TeacherRepo teacherRepo, GroupRepo groupRepo) {
        this.teacherRepo = teacherRepo;
        this.groupRepo = groupRepo;
    }


    @Override
    public ResponseEntity<?> assignTeacherToGroup(Long groupId, Long teacherId) {
        // Проверка существования группы и что она активна
        Group group = (Group) groupRepo.findByIdAndActiveIsTrue(groupId).orElseThrow(() -> new NotFoundException("Не найдена группа с ID: " + groupId));

        // Проверка существования воспитателя
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(() -> new NotFoundException("Не найден учитель с ID: " + teacherId));

        // Проверка, что воспитатель не прикреплён к другой активной группе
        Optional<Group> teacherGroup = groupRepo.findByTeacherAndActiveIsTrue(teacher);
        if (teacherGroup.isPresent() && !teacherGroup.get().getId().equals(groupId)) {
            throw new OperationNotAllowedException("Учитель уже назначен в другую активную группу");
        }

        // Проверка, что в группе ещё нет воспитателя
        if (group.getTeacher() != null) {
            throw new OperationNotAllowedException("Группа уже имеет назначенного учителя");
        }

        // Прикрепление воспитателя к группе
        group.setTeacher(teacher);
        groupRepo.save(group);

        return ResponseEntity.ok().build();
    }
}
