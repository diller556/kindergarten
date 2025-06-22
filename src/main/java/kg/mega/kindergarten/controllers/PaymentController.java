package kg.mega.kindergarten.controllers;

import jakarta.validation.Valid;
import kg.mega.kindergarten.models.dto.PaymentRequest;
import kg.mega.kindergarten.models.dto.PaymentResponse;
import kg.mega.kindergarten.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('payment:create') or hasRole('MANAGER') or hasRole('ADMIN')")
    public ResponseEntity<PaymentResponse> makePayment(@Valid @RequestBody PaymentRequest request) {
        return paymentService.makePayment(request);
    }
}
