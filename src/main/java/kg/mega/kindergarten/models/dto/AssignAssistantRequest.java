package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.NotBlank;

public class AssignAssistantRequest {
    @NotBlank
    private Long assistantId;

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }
}
