package softuni.spring_fund_exam.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.spring_fund_exam.model.entities.enums.BandName;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArtistServiceModel extends BaseServiceModel{

    private BandName name;

    private String careerInformation;
}
