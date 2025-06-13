package kg.mega.kindergarten.services;

import org.springframework.http.ResponseEntity;


public interface GroupService {
    ResponseEntity<?> assignTeacherToGroup(Long groupId, Long teacherId);
    ResponseEntity<?> assignAssistantToGroup(Long groupId, Long AssistantId);
}
