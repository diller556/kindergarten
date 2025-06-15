package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChildRepo extends JpaRepository<Child, UUID> { // Тип ID изменен на UUID
    Optional<Child> findByIdAndActiveIsTrue(UUID id);
    long countByGroupIdAndActiveIsTrue(Long groupId);
}
