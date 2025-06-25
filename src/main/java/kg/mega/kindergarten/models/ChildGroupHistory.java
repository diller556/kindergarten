package kg.mega.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import kg.mega.kindergarten.enums.Delete;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "child_group_history")
@Getter
@Setter
public class ChildGroupHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    @JsonIgnoreProperties({"children"})
    private Group group;
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    @JsonIgnoreProperties({"group"})
    private Child child;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
    @JsonIgnore
    private double debtAmount;
    @JsonIgnore
    private Delete delete = Delete.ACTIVE;

}
