package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "childrens")
@Getter
@Setter
public class Child extends Human{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @Past
    private LocalDate dateOfBirth;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToMany
    @JoinTable(
            name = "child_parents",
            joinColumns = @JoinColumn(name = "child_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "parent_id", nullable = false))
    private List<Parent> parents;
}
