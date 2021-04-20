package softuni.spring_fund_exam.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.spring_fund_exam.model.entities.AlbumEntity;
import softuni.spring_fund_exam.model.entities.ArtistEntity;
import softuni.spring_fund_exam.model.entities.UserEntity;
import softuni.spring_fund_exam.model.service.AlbumServiceModel;
import softuni.spring_fund_exam.model.view.AlbumViewModel;
import softuni.spring_fund_exam.repositories.AlbumRepository;
import softuni.spring_fund_exam.services.interfaces.AlbumService;
import softuni.spring_fund_exam.services.interfaces.ArtistService;
import softuni.spring_fund_exam.services.interfaces.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final UserService userService;
    private final ArtistService artistService;
    private final ModelMapper modelMapper;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository, UserService userService, ArtistService artistService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.userService = userService;
        this.artistService = artistService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AlbumServiceModel persist(AlbumServiceModel albumServiceModel, HttpSession httpSession) {
        //        TODO more validations for this user!

        String username = (String) httpSession.getAttribute("username");
        if (username == null) {
            return null;
        }

        UserEntity userEntity = this.modelMapper.map(this.userService.fetchByUserName(username), UserEntity.class);

        ArtistEntity artistEntity = this.modelMapper.map(this.artistService.fetchByBandName(albumServiceModel.getArtist().getName()), ArtistEntity.class);

        AlbumEntity albumEntity = this.modelMapper.map(albumServiceModel, AlbumEntity.class);
        albumEntity.setAddedFrom(userEntity);
        albumEntity.setArtist(artistEntity);

        return this.modelMapper.map(this.albumRepository.saveAndFlush(albumEntity), AlbumServiceModel.class);
    }

    @Override
    public List<AlbumViewModel> fetchAll() {
        return this.albumRepository
                .findAll()
                .stream()
                .map(albumEntity -> {
                    AlbumViewModel albumViewModel = this.modelMapper.map(albumEntity, AlbumViewModel.class);
                    albumViewModel.setArtist(albumEntity.getArtist().getName().name().toLowerCase());
                    albumViewModel.setGenre(albumEntity.getGenre().name().toLowerCase());
                    return albumViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Integer fetchTotalCopies() {
        return this.albumRepository
                .findAllAlbumsTotalCopies()
                .orElse(null);
    }

    @Override
    public AlbumServiceModel deleteById(String id) {
        AlbumServiceModel albumServiceModel = this.modelMapper.map(this.albumRepository.findById(id), AlbumServiceModel.class);

        this.albumRepository.deleteById(id);

        return albumServiceModel;
    }
}
