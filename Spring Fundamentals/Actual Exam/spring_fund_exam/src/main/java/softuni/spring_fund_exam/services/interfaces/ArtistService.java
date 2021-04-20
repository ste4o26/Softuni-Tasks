package softuni.spring_fund_exam.services.interfaces;

import softuni.spring_fund_exam.model.entities.enums.BandName;
import softuni.spring_fund_exam.model.service.ArtistServiceModel;

public interface ArtistService {
    ArtistServiceModel persist(ArtistServiceModel artistServiceModel);

    boolean isEmpty();

    ArtistServiceModel fetchByBandName(BandName bandName);
}
