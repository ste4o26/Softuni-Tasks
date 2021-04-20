package softuni.spring_fund_exam.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.spring_fund_exam.model.entities.enums.BandName;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "artists")
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private BandName name;

    @Column(name = "career_information", columnDefinition = "TEXT")
    private String careerInformation;
}
