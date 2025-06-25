package kg.mega.kindergarten.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import kg.mega.kindergarten.enums.PaymentType;
import kg.mega.kindergarten.models.Child;

import java.time.LocalDateTime;

public record PaymentDto (
        Long id,
        @JsonIgnore
        Child child,
        @JsonIgnore
        double paymentSum,

        @Schema(description = "Дата и время начала периода", example = "2025-05-06 15:34:56")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime paymentDate,
        @JsonIgnore
        String period,
        @JsonIgnore
        PaymentType paymentType
){
}
