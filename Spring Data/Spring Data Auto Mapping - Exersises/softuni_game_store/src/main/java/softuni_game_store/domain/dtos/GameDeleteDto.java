package softuni_game_store.domain.dtos;

import org.modelmapper.ModelMapper;
import softuni_game_store.domain.entities.Game;

public class GameDeleteDto {
    private String id;

    public GameDeleteDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void initMappings(ModelMapper modelMapper) {
        modelMapper
                .createTypeMap(GameDeleteDto.class, Game.class)
                .addMapping(GameDeleteDto::getId, Game::setId)
                .addMappings(mapper -> {
                    mapper.skip(Game::setDescription);
                    mapper.skip(Game::setImageThumbnail);
                    mapper.skip(Game::setPrice);
                    mapper.skip(Game::setTitle);
                    mapper.skip(Game::setSize);
                    mapper.skip(Game::setTrailerId);
                    mapper.skip(Game::setUsers);
                    mapper.skip(Game::setReleaseDate);
                });
    }
}
