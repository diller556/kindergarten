package kg.mega.kindergarten.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildGroupHistoryDebtDto{
    private Long childId;
    private double debtAmount;
}
