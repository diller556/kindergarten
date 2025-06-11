package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dto.TeacherCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "id", ignore = true)
    Teacher toTeacher(TeacherCreateDto teacherCreateDto);
    TeacherCreateDto toTeacherCreateDto(Teacher teacher);
}
