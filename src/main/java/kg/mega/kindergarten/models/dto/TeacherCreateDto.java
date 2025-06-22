package kg.mega.kindergarten.models.dto;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TeacherCreateDto {

    @NotNull
    @Past
    private LocalDate dateOfBirth;
    @Positive
    private Long contactId;
    @Positive
    private Long positionId;
}
