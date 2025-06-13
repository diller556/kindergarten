package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.repositories.AssistantRepo;
import kg.mega.kindergarten.services.AssistantService;
import org.springframework.stereotype.Service;

@Service
public class AssistantServiceImpl implements AssistantService {

    private final AssistantRepo assistantRepo;

    public AssistantServiceImpl(AssistantRepo assistantRepo) {
        this.assistantRepo = assistantRepo;
    }
}
