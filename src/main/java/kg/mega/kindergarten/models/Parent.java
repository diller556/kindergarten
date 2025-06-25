package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import kg.mega.kindergarten.enums.Role;
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
    private Role role;
    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
    @JsonIgnore
    private Delete delete = Delete.ACTIVE;
}
