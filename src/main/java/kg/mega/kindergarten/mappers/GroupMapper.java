package kg.mega.kindergarten.mappers;

import jakarta.validation.constraints.Positive;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dto.GroupCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    @Mapping(target = "id", ignore = true)
    Group toGroup(GroupCreateDto groupCreateDto);
    GroupCreateDto toGroupCreateDto(Group group);
}
