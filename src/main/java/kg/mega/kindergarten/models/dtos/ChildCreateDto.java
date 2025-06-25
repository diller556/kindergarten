package kg.mega.kindergarten.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.List;

public record ChildCreateDto (
        @NotBlank(message = "Имя не должно быть пустым")
        @Schema(description = "Имя ребенка", example = "Медер", required = true)
        String firstName,

        @NotBlank(message = "Фамилия не должна быть пустой")
        @Schema(description = "Фамилия ребенка", example = "Муратов", required = true)
        String lastName,

        @Schema(description = "Отчество ребенка", example = "Муратович", required = true)
        String patronymic,

        @NotNull(message = "Дата рождения обязательна")
        @Past(message = "Дата рождения должна быть в прошлом")
        @Schema(description = "Дата рождения ребенка", example = "2020-08-09", required = true, type = "string",format = "date")
        LocalDate dateOfBirth,
        Long group,
        List<Long> parentsId
){

}
