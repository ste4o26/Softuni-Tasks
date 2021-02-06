package softuni_game_store.domain.dtos;

import java.math.BigDecimal;

public class AllGameDto {
    private String title;
    private BigDecimal price;

    public AllGameDto() {
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
}
