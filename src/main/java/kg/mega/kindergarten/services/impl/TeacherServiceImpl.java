package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.repositories.TeacherRepo;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    public final TeacherRepo teacherRepo;

    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }
}
