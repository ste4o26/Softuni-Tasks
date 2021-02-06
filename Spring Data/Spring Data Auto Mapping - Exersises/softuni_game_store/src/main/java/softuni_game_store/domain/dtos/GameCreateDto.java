package softuni_game_store.domain.dtos;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameCreateDto {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailerId;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public GameCreateDto(String title, BigDecimal price, Double size, String trailerId, String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailerId = trailerId;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @NotNull(message = "Title can not be empty (null value)!")
    @Pattern(regexp = "[A-Z][a-z]{2,}")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull(message = "Price can not be null!")
//    @DecimalMin(value = "0.0", inclusive = false, message = "Price can not be negative number or 0!")
    @Positive(message = "Price can not be negative number!")
    @Digits(integer = 10, fraction = 2, message = "Price format ({10 digits}, {2 digits})!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "Size can not be null!")
//    @Min(value = 1)
    @Positive(message = "Size can not be negative number!")
    @Digits(integer = 9, fraction = 2, message = "Size format ({9 digits}, {2 digits})!")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @NotNull(message = "Trailer can not be null!")
    @Size(min = 11, max = 11)
    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    @Pattern(regexp = "((http|https)://)\\w*|.\\w+")
    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    @NotNull(message = "Description can not be null!")
    @Size(min = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
