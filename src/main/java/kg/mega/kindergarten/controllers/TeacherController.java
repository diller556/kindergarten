package kg.mega.kindergarten.controllers;

import kg.mega.kindergarten.models.dto.TeacherCreateDto;
import kg.mega.kindergarten.models.dto.TeacherDto;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController implements CRUDOperations<TeacherDto, TeacherCreateDto> {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        return null;
    }

    @Override
    public TeacherDto read(TeacherCreateDto teacherCreateDto) {
        return null;
    }

    @Override
    public List<TeacherDto> readAll(int page, int size) {
        return List.of();
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        return null;
    }

    @Override
    public boolean delete(TeacherCreateDto teacherCreateDto) {
        return false;
    }
}
