package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Assistant;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
    Optional<Group> findByTeacherAndActiveIsTrue(Teacher teacher);

    Optional<Group> findByAssistantAndActiveIsTrue(Assistant assistant);

    Optional<Object> findByIdAndActiveIsTrue(Long groupId);

}