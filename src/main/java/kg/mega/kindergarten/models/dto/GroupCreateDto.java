package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupCreateDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Positive
    private Long ageGroupId;
    @Positive
    private Long teacherId;
    @Positive
    private Long assistantId;
}
