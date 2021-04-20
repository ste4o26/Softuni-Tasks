package softuni.spring_fund_exam.model.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.spring_fund_exam.model.entities.enums.BandName;
import softuni.spring_fund_exam.model.entities.enums.GenreName;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumAddBindingModel {

    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotNull
    private String name;

    @Size(min = 5, message = "Image url length must be minimum 5(inclusive) characters.")
    @NotNull
    private String imageUrl;

    @Positive(message = "Price must be a positive number.")
    @NotNull
    private BigDecimal price;

    @Min(value = 10, message = "Must be a more than 10(inclusive).")
    @NotNull
    private Integer copies;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Release Date cannot be in the future.")
    @NotNull
    private LocalDate releaseDate;

    private String producer;

    @Size(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    @NotNull
    private String description;

    @NotNull(message = "You must select artist")
    private BandName artist;

    @NotNull(message = "You must select genre")
    private GenreName genre;
}
