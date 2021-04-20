package softuni.spring_fund_exam.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.spring_fund_exam.model.entities.enums.GenreName;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "albums")
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "copies", nullable = false)
    private Integer copies;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "producer")
    private String producer;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private GenreName genre;

    @ManyToOne(targetEntity = ArtistEntity.class)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private ArtistEntity artist;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity addedFrom;
}
