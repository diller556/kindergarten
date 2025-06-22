package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import kg.mega.kindergarten.enums.TeacherPosition;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher extends Human{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private TeacherPosition position;
}
