package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentCreateDto {

    @Positive
    private Long contactId;
    @Positive
    private Long roleId;
}
