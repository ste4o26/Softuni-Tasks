package softuni_game_store.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni_game_store.domain.dtos.GameDeleteDto;
import softuni_game_store.domain.dtos.UserRegisterDto;

@Configuration
public class ModelMapperConfiguration {
    private static ModelMapper modelMapper = new ModelMapper();

    public ModelMapperConfiguration() {
    }

    static {
        UserRegisterDto.initMappings(modelMapper);
        GameDeleteDto.initMappings(modelMapper);
        modelMapper.validate();
    }

    @Bean
    public ModelMapper modelMapper() {
        return modelMapper;
    }
}
