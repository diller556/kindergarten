package kg.mega.kindergarten.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgeGroupMapper {
    AgeGroupMapper INSTANCE = Mappers.getMapper(AgeGroupMapper.class);




}
