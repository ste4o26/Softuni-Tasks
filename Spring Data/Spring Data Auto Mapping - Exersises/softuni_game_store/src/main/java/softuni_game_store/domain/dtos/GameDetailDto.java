package softuni_game_store.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDetailDto {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate localDate;

    public GameDetailDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
