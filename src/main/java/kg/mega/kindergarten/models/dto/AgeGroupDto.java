package kg.mega.kindergarten.models.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeGroupDto extends AgeGroupCreateDto{
    @NotNull
    @Positive
    private Long id;
}
