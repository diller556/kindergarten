package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import kg.mega.kindergarten.enums.ParentRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parents")
@Getter
@Setter
public class Parent extends Human{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private ParentRole role;
}
