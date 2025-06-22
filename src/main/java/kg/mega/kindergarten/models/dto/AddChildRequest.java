package kg.mega.kindergarten.models.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class AddChildRequest {
    @NotNull(message = "ID ребенка не может быть пустым!")
    private UUID childId;


}
