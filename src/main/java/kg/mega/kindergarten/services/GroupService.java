package kg.mega.kindergarten.services;

import org.springframework.http.ResponseEntity;
import java.util.UUID;


public interface GroupService {
    ResponseEntity<?> assignTeacherToGroup(Long groupId, Long teacherId);
    ResponseEntity<?> assignAssistantToGroup(Long groupId, Long AssistantId);
    ResponseEntity<?> addChildToGroup(Long groupId, UUID childId);
}
