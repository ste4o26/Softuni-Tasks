package softuni_game_store.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni_game_store.domain.dtos.AllGameDto;
import softuni_game_store.domain.dtos.GameCreateDto;
import softuni_game_store.domain.dtos.GameDeleteDto;
import softuni_game_store.domain.dtos.GameDetailDto;
import softuni_game_store.domain.entities.Game;
import softuni_game_store.reposiotries.GameRepository;
import softuni_game_store.services.interfaces.GameService;
import softuni_game_store.domain.dtos.OwnedGameDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public String addGame(GameCreateDto gameCreateDto) {
        Game game = this.modelMapper.map(gameCreateDto, Game.class);

        this.gameRepository.saveAndFlush(game);

        return String.format("Added %s", game.getTitle());
    }

    //TODO da go napravq da priema string id da vzema iztriva igrata ot repozitorito i da vrushta obekt za da si vzema title-a...i da iztriq GameDeleteDto
    @Override
    public String deleteGame(GameDeleteDto gameDeleteDto) {
        String title = this.gameRepository
                .findById(gameDeleteDto.getId())
                .orElseThrow(IllegalStateException::new)
                .getTitle();

        Game game = this.modelMapper.map(gameDeleteDto, Game.class);
        this.gameRepository.delete(game);

        return String.format("Deleted %s", title);
    }

    @Override
    public List<AllGameDto> fetchAllGames() {
        return this.gameRepository
                .findAll()
                .stream()
                .map(game -> this.modelMapper.map(game, AllGameDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GameDetailDto fetchGameByTitle(String title) {
        Game game = this.gameRepository.findByTitle(title).orElse(null);
        if (game == null) {
            throw new IllegalArgumentException(String.format("No game with title %s was found", title));
        }

        return this.modelMapper.map(game, GameDetailDto.class);
    }

    @Override
    public List<OwnedGameDto> fetchOwnedGames(String email) {
        return this.gameRepository.findByUsers_Email(email)
                .stream()
                .map(game -> this.modelMapper.map(game, OwnedGameDto.class))
                .collect(Collectors.toList());
    }
}
