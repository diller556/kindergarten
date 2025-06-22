package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import kg.mega.kindergarten.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double paymentSum;
    private LocalDate paymentDate;
    private String period;
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;


}
