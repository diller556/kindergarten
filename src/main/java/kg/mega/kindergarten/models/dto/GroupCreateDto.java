package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.*;
import kg.mega.kindergarten.models.AgeGroup;

public class GroupCreateDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Positive
    private Long ageGroupId;
    @Positive
    private Long teacherId;
    @Positive
    private Long assistantId;

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(Long ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
