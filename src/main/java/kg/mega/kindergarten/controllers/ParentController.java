package kg.mega.kindergarten.controllers;

import kg.mega.kindergarten.models.dto.ParentCreateDto;
import kg.mega.kindergarten.models.dto.ParentDto;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/parent")
public class ParentController implements CRUDOperations<ParentDto, ParentCreateDto> {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @Override
    public ParentDto create(ParentDto parentDto) {
        return null;
    }

    @Override
    public ParentDto read(ParentCreateDto parentCreateDto) {
        return null;
    }

    @Override
    public List<ParentDto> readAll(int page, int size) {
        return List.of();
    }

    @Override
    public ParentDto update(ParentDto parentDto) {
        return null;
    }

    @Override
    public boolean delete(ParentCreateDto parentCreateDto) {
        return false;
    }
}
