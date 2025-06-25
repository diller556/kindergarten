package kg.mega.kindergarten.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Teacher;

import java.util.List;

public record GroupDto (
        Long id,

        @NotBlank(message = "Название группы не должно быть пустым")
        @Schema(description = "Название группы", example = "Старшая группа А", required = true)
        String name,

        @NotNull(message = "Возрастная категория обязательна")
        AgeGroup ageGroup,
        Teacher teacher,
        Teacher assistant,
        @JsonIgnoreProperties({"group"})
        List<Child> children
){
}
