package kg.mega.kindergarten.controllers;

import kg.mega.kindergarten.models.dto.AssistantCreateDto;
import kg.mega.kindergarten.models.dto.AssistantDto;
import kg.mega.kindergarten.services.AssistantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/assistant")
public class AssistantController implements CRUDOperations<AssistantDto, AssistantCreateDto> {

    private AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @Override
    public AssistantDto create(AssistantDto assistantDto) {
        return null;
    }

    @Override
    public AssistantDto read(AssistantCreateDto assistantCreateDto) {
        return null;
    }

    @Override
    public List<AssistantDto> readAll(int page, int size) {
        return List.of();
    }

    @Override
    public AssistantDto update(AssistantDto assistantDto) {
        return null;
    }

    @Override
    public boolean delete(AssistantCreateDto assistantCreateDto) {
        return false;
    }
}
