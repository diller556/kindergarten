package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "assistant_id")
    private Teacher assistant;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"group"})
    private List<Child> children;

    @JsonIgnore
    private Delete delete = Delete.ACTIVE;


    public void addChild(Child child) {
        children.add(child);
        child.setGroupId(this);
    }

    public void removeChild(Child child) {
        children.remove(child);
        child.setGroup(null);
    }

}
