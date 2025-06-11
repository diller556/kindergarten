package kg.mega.kindergarten.models.dto;

import jakarta.validation.constraints.*;

public class AgeGroupCreateDto {
    @NotBlank
    @Size(min=1, max=50)
    private String name;
    @NotNull
    @PositiveOrZero
    private double price;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
