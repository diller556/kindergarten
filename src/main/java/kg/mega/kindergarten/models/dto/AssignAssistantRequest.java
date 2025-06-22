package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignAssistantRequest {
    @NotBlank
    private Long assistantId;

}
