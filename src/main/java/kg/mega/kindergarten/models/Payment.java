package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import kg.mega.kindergarten.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;
    private double paymentSum;
    private LocalDateTime paymentDate;
    private String period;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @JsonIgnore
    private Delete delete = Delete.ACTIVE;
}
