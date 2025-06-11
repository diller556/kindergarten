package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.Positive;

public class ParentCreateDto {

    @Positive
    private Long contactId;
    @Positive
    private Long roleId;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
