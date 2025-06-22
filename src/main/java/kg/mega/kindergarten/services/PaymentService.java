package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.dto.PaymentRequest;
import kg.mega.kindergarten.models.dto.PaymentResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity<PaymentResponse> makePayment(PaymentRequest request);
}
