package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import kg.mega.kindergarten.enums.Position;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher extends Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Position position;
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
    @JsonIgnore
    private Delete delete = Delete.ACTIVE;
}
