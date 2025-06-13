package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepo extends JpaRepository<Assistant, Long> {
}
