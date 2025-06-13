package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Assistant;
import kg.mega.kindergarten.models.dto.AssistantCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssistantMapper {
    AssistantMapper INSTANCE = Mappers.getMapper(AssistantMapper.class);

    @Mapping(target = "id", ignore = true)
    Assistant toAssistant(AssistantCreateDto assistantCreateDto);
    AssistantCreateDto toAssistantCreateDto(Assistant assistant);
}
