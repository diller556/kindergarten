package kg.mega.kindergarten.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface GroupService {
    ResponseEntity<?> assignTeacherToGroup(Long groupId, Long teacherId);
}
