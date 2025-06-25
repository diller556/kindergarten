package kg.mega.kindergarten.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record PaymentCreateDto(

        @NotNull(message = "ID ребёнка обязателен")
        @Schema(description = "ID ребёнка", example = "1", required = true)
        Long childId,

        @JsonIgnore
        LocalDateTime paymentDate,

        @NotBlank(message = "Период оплаты обязателен")
        @Pattern(
                regexp = "(0[1-9]|1[0-2])\\.\\d{4}",
                message = "Период должен быть в формате MM.yyyy, например: 12.2024"
        )
        @Schema(description = "Период оплаты", type = "string", pattern = "MM.yyyy", example = "12.2024", required = true)
        String period,

        @Positive(message = "Сумма оплаты должна быть положительной")
        @Schema(description = "Сумма оплаты", example = "10000", required = true)
        double paymentSum
) {}
