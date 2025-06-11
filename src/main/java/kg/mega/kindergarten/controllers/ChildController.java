package kg.mega.kindergarten.controllers;

import kg.mega.kindergarten.models.dto.ChildCreateDto;
import kg.mega.kindergarten.models.dto.ChildDto;
import kg.mega.kindergarten.services.ChildService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/child")
public class ChildController implements CRUDOperations<ChildDto, ChildCreateDto>{
    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @Override
    public ChildDto create(ChildDto childDto) {
        return null;
    }

    @Override
    public ChildDto read(ChildCreateDto childCreateDto) {
        return null;
    }

    @Override
    public List<ChildDto> readAll(int page, int size) {
        return List.of();
    }

    @Override
    public ChildDto update(ChildDto childDto) {
        return null;
    }

    @Override
    public boolean delete(ChildCreateDto childCreateDto) {
        return false;
    }
}
