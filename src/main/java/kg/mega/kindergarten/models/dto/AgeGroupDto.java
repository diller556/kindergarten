package kg.mega.kindergarten.models.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AgeGroupDto extends AgeGroupCreateDto{
    @NotNull
    @Positive
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
