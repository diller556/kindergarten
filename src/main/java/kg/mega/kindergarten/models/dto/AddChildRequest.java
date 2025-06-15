package kg.mega.kindergarten.models.dto;


import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class AddChildRequest {
    @NotNull(message = "ID ребенка не может быть пустым!")
    private UUID childId;

    public UUID getChildId() {
        return childId;
    }

    public void setChildId(UUID childId) {
        this.childId = childId;
    }
}
