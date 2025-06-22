package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "age_group_id", nullable = false)
    private AgeGroup ageGroup;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    private boolean active = true;
    @ManyToOne
    @JoinColumn(name = "assistant_id")
    private Assistant assistant;
}
