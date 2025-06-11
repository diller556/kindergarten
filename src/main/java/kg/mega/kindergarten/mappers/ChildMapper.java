package kg.mega.kindergarten.mappers;


import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.dto.ChildCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

@Mapper(uses = {AgeGroupMapper.class})
public interface ChildMapper {
    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);

    @Mapping(target = "id", ignore = true)
    Child toChild(ChildCreateDto childCreateDto);
    ChildCreateDto toChildCreateDto(Child child);


}