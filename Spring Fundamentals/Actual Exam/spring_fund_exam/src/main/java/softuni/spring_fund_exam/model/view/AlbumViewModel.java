package softuni.spring_fund_exam.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.spring_fund_exam.model.entities.enums.BandName;
import softuni.spring_fund_exam.model.entities.enums.GenreName;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumViewModel {
    private String id;

    private String name;

    private String artist;

    private String imageUrl;

    private String genre;

    private BigDecimal price;

    private LocalDate releaseDate;

    private Integer copies;
}
