package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.exceptions.NotFoundException;
import kg.mega.kindergarten.exceptions.OperationNotAllowedException;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dto.PaymentRequest;
import kg.mega.kindergarten.models.dto.PaymentResponse;
import kg.mega.kindergarten.repositories.ChildRepo;
import kg.mega.kindergarten.repositories.PaymentRepo;
import kg.mega.kindergarten.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final ChildRepo childRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo, ChildRepo childRepo) {
        this.paymentRepo = paymentRepo;
        this.childRepo = childRepo;
    }

    @Override
    @Transactional
    public ResponseEntity<PaymentResponse> makePayment(PaymentRequest request) {
        Child child = childRepo.findByIdAndActiveIsTrue(request.getChildId()).orElseThrow(() -> new NotFoundException("Активный ребенок не найден с ID: " + request.getChildId()));

        if (request.getPaymentSum() <= 0) {
            throw new OperationNotAllowedException("Сумма платежа должна быть больше 0.");
        }

        if (child.getGroup() == null) {
            throw new OperationNotAllowedException("Ребенок не состоит в активной группе. Невозможно принять платеж.");
        }
        if (!child.getGroup().isActive()) {
            throw new OperationNotAllowedException("Группа, в которой состоит ребенок, неактивна. Невозможно принять платеж.");
        }

        Payment payment = new Payment();
        payment.setChild(child);
        payment.setPaymentSum(request.getPaymentSum());
        payment.setPaymentType(request.getPaymentType()); // Здесь тип уже PaymentType enum
        payment.setPeriod(request.getPeriod());
        payment.setPaymentDate(LocalDate.from(LocalDateTime.now()));

        Payment savedPayment = paymentRepo.save(payment);

        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(savedPayment.getId());
        response.setPaymentDate(savedPayment.getPaymentDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));

        return ResponseEntity.ok(response);
    }
}