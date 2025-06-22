package kg.mega.kindergarten.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Human {
    @NotBlank
    @Size(min = 1)
    private String firstName;
    private String LastName;
}
