package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String secondaryPhoneNumber;
    private String email;
    @JsonIgnore
    private Delete delete = Delete.ACTIVE;

}
