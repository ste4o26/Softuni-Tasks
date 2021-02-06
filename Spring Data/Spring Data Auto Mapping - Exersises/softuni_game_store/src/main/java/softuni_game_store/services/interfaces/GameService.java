package softuni_game_store.services.interfaces;

import softuni_game_store.domain.dtos.AllGameDto;
import softuni_game_store.domain.dtos.GameCreateDto;
import softuni_game_store.domain.dtos.GameDeleteDto;
import softuni_game_store.domain.dtos.GameDetailDto;
import softuni_game_store.domain.dtos.OwnedGameDto;

import java.util.List;

public interface GameService {
    String addGame(GameCreateDto gameCreateDto);

    //TODO String editGame(...);

    String deleteGame(GameDeleteDto gameDeleteDto);

    List<AllGameDto> fetchAllGames();

    GameDetailDto fetchGameByTitle(String title);

    List<OwnedGameDto> fetchOwnedGames(String loggedInUserEmail);
}
