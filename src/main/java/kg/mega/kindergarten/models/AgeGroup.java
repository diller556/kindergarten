package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "age_groups")
@Getter
@Setter
public class AgeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int ageGroup;
    private double price;

    @JsonIgnore
    private Delete delete = Delete.ACTIVE;
}
