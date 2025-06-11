package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.dto.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dto.AgeGroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgeGroupMapper {
    AgeGroupMapper INSTANCE = Mappers.getMapper(AgeGroupMapper.class);

    @Mapping(target = "id", ignore = true)
    AgeGroup toAgeGroup(AgeGroupCreateDto ageGroupCreateDto);
    AgeGroupCreateDto toAgeGroupCreateDto(AgeGroup ageGroup);


}
