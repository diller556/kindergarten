package kg.mega.kindergarten.controllers;

import kg.mega.kindergarten.models.dto.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dto.AgeGroupDto;
import kg.mega.kindergarten.services.AgeGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/age")
public class AgeGroupController implements CRUDOperations<AgeGroupDto, AgeGroupCreateDto> {
    private final AgeGroupService ageGroupService;

    public AgeGroupController(AgeGroupService ageGroupService) {
        this.ageGroupService = ageGroupService;
    }

    @Override
    public AgeGroupDto create(AgeGroupDto ageGroupDto) {
        return null;
    }

    @Override
    public AgeGroupDto read(AgeGroupCreateDto ageGroupCreateDto) {
        return null;
    }

    @Override
    public List<AgeGroupDto> readAll(int page, int size) {
        return List.of();
    }

    @Override
    public AgeGroupDto update(AgeGroupDto ageGroupDto) {
        return null;
    }

    @Override
    public boolean delete(AgeGroupCreateDto ageGroupCreateDto) {
        return false;
    }
}
