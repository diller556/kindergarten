package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeGroupCreateDto {
    @NotBlank
    @Size(min=1, max=50)
    private String name;
    @NotNull
    @PositiveOrZero
    private double price;
    private boolean active;
}
