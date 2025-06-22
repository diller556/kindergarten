package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kg.mega.kindergarten.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PaymentRequest {
    @NotNull(message = "ID ребенка не может быть пустым")
    private UUID childId;

    @NotNull(message = "Сумма платежа не может быть пустой")
    @DecimalMin(value = "0.01", message = "Сумма платежа должна быть больше 0")
    private Double paymentSum;

    @NotNull(message = "Тип платежа не может быть пустым")
    private PaymentType paymentType;

    @NotBlank(message = "Период оплаты не может быть пустым")
    private String period;

}
