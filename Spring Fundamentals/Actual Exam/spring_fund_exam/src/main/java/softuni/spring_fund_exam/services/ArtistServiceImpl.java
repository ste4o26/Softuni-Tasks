package softuni.spring_fund_exam.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.spring_fund_exam.model.entities.ArtistEntity;
import softuni.spring_fund_exam.model.entities.enums.BandName;
import softuni.spring_fund_exam.model.service.ArtistServiceModel;
import softuni.spring_fund_exam.repositories.ArtistRepository;
import softuni.spring_fund_exam.services.interfaces.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, ModelMapper modelMapper) {
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ArtistServiceModel persist(ArtistServiceModel artistServiceModel) {
        ArtistEntity artistEntity = this.modelMapper.map(artistServiceModel, ArtistEntity.class);

        return this.modelMapper
                .map(this.artistRepository.saveAndFlush(artistEntity),
                        ArtistServiceModel.class);
    }

    @Override
    public boolean isEmpty() {
        return this.artistRepository.count() == 0;
    }

    @Override
    public ArtistServiceModel fetchByBandName(BandName bandName) {
        ArtistEntity artistEntity = this.artistRepository
                .findByName(bandName)
                .orElse(null);

        if (artistEntity == null){
            return null;
        }

        return this.modelMapper.map(artistEntity, ArtistServiceModel.class);
    }
}
